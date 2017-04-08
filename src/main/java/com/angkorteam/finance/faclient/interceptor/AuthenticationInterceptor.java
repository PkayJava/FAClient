package com.angkorteam.finance.faclient.interceptor;

import com.angkorteam.finance.faclient.dto.system.Authentication;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class AuthenticationInterceptor implements Interceptor {

    private static final String AUTHENTICATION = "api/v1/authentication";

    private final String tenant;

    public AuthenticationInterceptor(String tenant) {
        this.tenant = tenant;
    }

    private Authentication authentication;

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.header("Fineract-Platform-TenantId", this.tenant);
        if (this.authentication != null) {
            builder.header("Authorization", "Basic " + this.authentication.getBase64EncodedAuthenticationKey());
        }
        Request request = builder.build();
        Response response = chain.proceed(request);
        if (request.url().encodedPath().endsWith(AUTHENTICATION)) {
            if (response.code() == 200) {
                Gson gson = new Gson();
                String string = response.body().string();
                this.authentication = gson.fromJson(string, Authentication.class);
                Response.Builder cached = new Response.Builder();
                cached.body(ResponseBody.create(MediaType.parse("application/json"), string.getBytes()));
                cached.protocol(response.protocol());
                cached.code(response.code());
                cached.request(response.request());
                response = cached.build();
            }
        }

        return response;
    }

}
