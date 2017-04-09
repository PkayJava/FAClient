package com.angkorteam.finance.server;

import com.angkorteam.finance.server.factory.ConnectionRequestCycle;
import com.angkorteam.finance.server.page.HomePage;
import com.angkorteam.finance.server.page.LoginPage;
import com.angkorteam.finance.server.page.RequestPage;
import com.angkorteam.finance.server.page.UploadPage;
import com.angkorteam.finance.server.page.client.ClientBrowsePage;
import org.apache.commons.configuration.XMLPropertiesConfiguration;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.resource.DynamicJQueryResourceReference;
import org.apache.wicket.settings.ExceptionSettings;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 */
public class Application extends AuthenticatedWebApplication {

    @Override
    public void init() {
        super.init();
        ServletContext servletContext = getServletContext();
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        getExceptionSettings().setAjaxErrorHandlingStrategy(ExceptionSettings.AjaxErrorStrategy.REDIRECT_TO_ERROR_PAGE);
        getExceptionSettings().setThreadDumpStrategy(ExceptionSettings.ThreadDumpStrategy.THREAD_HOLDING_LOCK);
        getExceptionSettings().setUnexpectedExceptionDisplay(ExceptionSettings.SHOW_EXCEPTION_PAGE);
        getRequestCycleListeners().add(applicationContext.getBean(ConnectionRequestCycle.class));
        getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
        getRequestCycleSettings().setBufferResponse(true);
        getMarkupSettings().setCompressWhitespace(true);
        getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
        getMarkupSettings().setStripWicketTags(true);
        getMarkupSettings().setStripComments(true);
        getJavaScriptLibrarySettings().setJQueryReference(new DynamicJQueryResourceReference());
        initPageMount();
    }

    @Override
    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return Session.class;
    }

    @Override
    protected Class<? extends WebPage> getSignInPageClass() {
        return LoginPage.class;
    }

    @Override
    public Class<? extends org.apache.wicket.Page> getHomePage() {
        return HomePage.class;
    }

    protected void initPageMount() {
        mountPage("/upload", UploadPage.class);
        mountPage("/request", RequestPage.class);
        mountPage("/login", LoginPage.class);
        mountPage("/client/browse", ClientBrowsePage.class);
    }

    @Override
    public RuntimeConfigurationType getConfigurationType() {
        XMLPropertiesConfiguration configuration = Platform.getBean(XMLPropertiesConfiguration.class);
        return RuntimeConfigurationType.valueOf(configuration.getString(Platform.WICKET));
    }
}
