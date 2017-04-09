package com.angkorteam.finance.server.page;

import com.angkorteam.framework.wicket.AdminLTEPage;
import com.angkorteam.framework.wicket.markup.html.form.Button;
import com.angkorteam.framework.wicket.markup.html.panel.TextFeedbackPanel;
import com.angkorteam.finance.server.Session;
import com.angkorteam.finance.server.widget.ApplicationFeedbackPanel;
import org.apache.wicket.NonResettingRestartException;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.cycle.RequestCycle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class LoginPage extends AdminLTEPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    private StatelessForm<Void> form;

    private String usernameValue;
    private TextField<String> usernameField;
    private TextFeedbackPanel usernameFeedback;

    private String passwordValue;
    private TextField<String> passwordField;
    private TextFeedbackPanel passwordFeedback;

    private Button loginButton;

    private Url originalUrl;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.originalUrl = RestartResponseAtInterceptPageException.getOriginalUrl();

        this.form = new StatelessForm<>("form");
        add(this.form);

        this.usernameField = new TextField<>("usernameField", new PropertyModel<>(this, "usernameValue"));
        this.usernameField.setLabel(Model.of("Username"));
        this.form.add(this.usernameField);
        this.usernameField.setRequired(true);
        this.usernameFeedback = new TextFeedbackPanel("usernameFeedback", this.usernameField);
        this.form.add(this.usernameFeedback);

        this.passwordField = new PasswordTextField("passwordField", new PropertyModel<>(this, "passwordValue"));
        this.passwordField.setLabel(Model.of("Password"));
        this.form.add(this.passwordField);
        this.passwordField.setRequired(true);
        this.passwordFeedback = new TextFeedbackPanel("passwordFeedback", this.passwordField);
        this.form.add(this.passwordFeedback);

        this.loginButton = new Button("loginButton");
        this.form.add(this.loginButton);
        this.loginButton.setOnSubmit(this::loginButtonSubmit);

        ApplicationFeedbackPanel informationSuccess = new ApplicationFeedbackPanel("informationSuccess", ApplicationFeedbackPanel.Level.Success);
        add(informationSuccess);

        ApplicationFeedbackPanel informationInfo = new ApplicationFeedbackPanel("informationInfo", ApplicationFeedbackPanel.Level.Info);
        add(informationInfo);

        ApplicationFeedbackPanel informationDanger = new ApplicationFeedbackPanel("informationDanger", ApplicationFeedbackPanel.Level.Danger);
        add(informationDanger);

        ApplicationFeedbackPanel informationWarning = new ApplicationFeedbackPanel("informationWarning", ApplicationFeedbackPanel.Level.Warning);
        add(informationWarning);
    }

    private void loginButtonSubmit(Button button) {
        boolean valid = Session.get().signIn(this.usernameValue, this.passwordValue);
        if (valid) {
            if (this.originalUrl != null) {
                String url = RequestCycle.get().getUrlRenderer().renderUrl(this.originalUrl);
                throw new NonResettingRestartException(url);
            } else {
                setResponsePage(getApplication().getHomePage());
            }
        }
    }

}
