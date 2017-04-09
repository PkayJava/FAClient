package com.angkorteam.finance.server;

import com.angkorteam.finance.faclient.SystemService;
import com.angkorteam.finance.faclient.dto.common.Feedback;
import com.angkorteam.finance.faclient.dto.system.Authentication;
import com.angkorteam.finance.faclient.dto.system.Role;
import com.google.gson.Gson;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class Session extends AuthenticatedWebSession {

    private static final Logger LOGGER = LoggerFactory.getLogger(Session.class);

    private Roles roles;

    private Authentication authentication;

    public Session(Request request) {
        super(request);
        this.roles = new Roles();
    }

    public final Authentication getAuthentication() {
        return this.authentication;
    }

    @Override
    protected boolean authenticate(String username, String password) {
        Gson gson = Platform.getBean(Gson.class);
        SystemService systemService = Platform.getBean(SystemService.class);
        Call<Authentication> call = systemService.authentication(username, password);
        try {
            Response<Authentication> response = call.execute();
            if (!response.isSuccessful()) {
                String string = response.errorBody().string();
                System.out.println(string);
                Feedback feedback = gson.fromJson(string, Feedback.class);
                error(feedback.getDefaultUserMessage());
            } else {
                this.roles.add(username);
                this.authentication = response.body();
                for (Role role : this.authentication.getRoles()) {
                    this.roles.add(role.getName());
                }
            }
        } catch (IOException e) {
            error(e.getMessage());
            LOGGER.info(e.getMessage(), e);
        }
        return this.authentication != null;
    }

    @Override
    public Roles getRoles() {
        return this.roles;
    }

}