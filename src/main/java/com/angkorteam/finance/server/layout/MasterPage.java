package com.angkorteam.finance.server.layout;

import com.angkorteam.finance.server.Session;
import com.angkorteam.finance.server.page.HomePage;
import com.angkorteam.finance.server.page.admin.OrganizationPage;
import com.angkorteam.finance.server.page.admin.ProductPage;
import com.angkorteam.finance.server.page.admin.SystemPage;
import com.angkorteam.finance.server.page.client.CenterBrowsePage;
import com.angkorteam.finance.server.page.client.ClientBrowsePage;
import com.angkorteam.finance.server.page.client.GroupBrowsePage;
import com.angkorteam.finance.server.widget.ApplicationFeedbackPanel;
import com.angkorteam.finance.server.widget.BreadcrumbWidget;
import com.angkorteam.finance.server.widget.MenuWidget;
import com.angkorteam.finance.server.widget.SidebarWidget;
import com.angkorteam.framework.wicket.AdminLTEPage;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public abstract class MasterPage extends AdminLTEPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MasterPage.class);

    private String welcomeName;

    private RepeatingView clientMenuItemWidget;

    private RepeatingView adminMenuItemWidget;

    private RepeatingView reportMenuItemWidget;

    private RepeatingView sidebarWidget;

    private RepeatingView khmerMFMenuItemWidget;

    private WebMarkupContainer breadcrumbContainer;

    private RepeatingView breadcrumbItemWidget;

    public MasterPage() {
    }

    public MasterPage(IModel<?> model) {
        super(model);
    }

    public MasterPage(PageParameters parameters) {
        super(parameters);
    }

    protected void initData(PageParameters parameters) throws Throwable {
    }

    protected void initInterface() throws Throwable {
    }

    @Override
    protected final void onInitialize() {
        super.onInitialize();

        try {
            initData(getPageParameters());
        } catch (Throwable throwable) {
            throw new WicketRuntimeException(throwable);
        }

        List<MenuWidget.Menu> clientMenu = buildClientMenu();
        List<MenuWidget.Menu> adminMenu = buildAdminMenu();
        List<MenuWidget.Menu> reportMenu = buildReportMenu();
        List<SidebarWidget.Sidebar> sidebar = buildSidebar();
        List<MenuWidget.Menu> khmerMFMenu = buildKhmerMFMenu();
        List<BreadcrumbWidget.Breadcrumb> breadcrumb = buildBreadcrumb();

        ApplicationFeedbackPanel informationSuccess = new ApplicationFeedbackPanel("informationSuccess", ApplicationFeedbackPanel.Level.Success);
        add(informationSuccess);

        ApplicationFeedbackPanel informationInfo = new ApplicationFeedbackPanel("informationInfo", ApplicationFeedbackPanel.Level.Info);
        add(informationInfo);

        ApplicationFeedbackPanel informationDanger = new ApplicationFeedbackPanel("informationDanger", ApplicationFeedbackPanel.Level.Danger);
        add(informationDanger);

        ApplicationFeedbackPanel informationWarning = new ApplicationFeedbackPanel("informationWarning", ApplicationFeedbackPanel.Level.Warning);
        add(informationWarning);

        getFeedbackMessages().messages(FeedbackMessage::isSuccess);

        Label yearLabel = new Label("yearLabel", DateFormatUtils.format(new Date(), "yyyy"));
        add(yearLabel);

        BookmarkablePageLink<Void> accountingPage = new BookmarkablePageLink<Void>("accountingPage", HomePage.class, new PageParameters());
        add(accountingPage);

        this.clientMenuItemWidget = new RepeatingView("clientMenuItemWidget");
        add(this.clientMenuItemWidget);

        this.adminMenuItemWidget = new RepeatingView("adminMenuItemWidget");
        add(this.adminMenuItemWidget);

        this.reportMenuItemWidget = new RepeatingView("reportMenuItemWidget");
        add(this.reportMenuItemWidget);

        this.sidebarWidget = new RepeatingView("sidebarWidget");
        add(this.sidebarWidget);

        this.khmerMFMenuItemWidget = new RepeatingView("khmerMFMenuItemWidget");
        add(this.khmerMFMenuItemWidget);

        this.breadcrumbContainer = new WebMarkupContainer("breadcrumbContainer");
        add(this.breadcrumbContainer);
        this.breadcrumbItemWidget = new RepeatingView("breadcrumbItemWidget");
        this.breadcrumbContainer.add(this.breadcrumbItemWidget);

        for (MenuWidget.Menu item : clientMenu == null ? new ArrayList<MenuWidget.Menu>() : clientMenu) {
            String id = this.clientMenuItemWidget.newChildId();
            MenuWidget menuWidget = new MenuWidget(id, item);
            if (item.isActive()) {
                menuWidget.add(AttributeModifier.replace("class", "active"));
            }
            this.clientMenuItemWidget.add(menuWidget);
        }

        for (MenuWidget.Menu item : adminMenu == null ? new ArrayList<MenuWidget.Menu>() : adminMenu) {
            String id = this.adminMenuItemWidget.newChildId();
            MenuWidget menuWidget = new MenuWidget(id, item);
            if (item.isActive()) {
                menuWidget.add(AttributeModifier.replace("class", "active"));
            }
            this.adminMenuItemWidget.add(menuWidget);
        }

        for (MenuWidget.Menu item : reportMenu == null ? new ArrayList<MenuWidget.Menu>() : reportMenu) {
            String id = this.reportMenuItemWidget.newChildId();
            MenuWidget menuWidget = new MenuWidget(id, item);
            if (item.isActive()) {
                menuWidget.add(AttributeModifier.replace("class", "active"));
            }
            this.reportMenuItemWidget.add(menuWidget);
        }

        for (SidebarWidget.Sidebar item : sidebar == null ? new ArrayList<SidebarWidget.Sidebar>() : sidebar) {
            String id = this.sidebarWidget.newChildId();
            SidebarWidget menuWidget = new SidebarWidget(id, item);
            if (item.isActive()) {
                menuWidget.add(AttributeModifier.replace("class", "active"));
            }
            this.sidebarWidget.add(menuWidget);
        }

        for (MenuWidget.Menu item : khmerMFMenu == null ? new ArrayList<MenuWidget.Menu>() : khmerMFMenu) {
            String id = this.khmerMFMenuItemWidget.newChildId();
            MenuWidget menuWidget = new MenuWidget(id, item);
            if (item.isActive()) {
                menuWidget.add(AttributeModifier.replace("class", "active"));
            }
            this.khmerMFMenuItemWidget.add(menuWidget);
        }

        for (BreadcrumbWidget.Breadcrumb item : breadcrumb == null ? new ArrayList<BreadcrumbWidget.Breadcrumb>() : breadcrumb) {
            String id = this.breadcrumbItemWidget.newChildId();
            BreadcrumbWidget breadcrumbWidget = new BreadcrumbWidget(id, item);
            this.breadcrumbItemWidget.add(breadcrumbWidget);
        }
        if (breadcrumb == null || breadcrumb.isEmpty()) {
            this.breadcrumbContainer.setVisible(false);
        }

        try {
            initInterface();
        } catch (Throwable throwable) {
            throw new WicketRuntimeException(throwable);
        }

    }

    @Override
    public Session getSession() {
        return (Session) super.getSession();
    }

    protected List<BreadcrumbWidget.Breadcrumb> buildBreadcrumb() {
        return null;
    }

    protected List<SidebarWidget.Sidebar> buildSidebar() {
        List<SidebarWidget.Sidebar> sidebars = new ArrayList<>();
        sidebars.add(new SidebarWidget.Sidebar(false, "Keyboard Shortcuts", "fa fa-keyboard-o", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Navigation", "fa fa-bolt", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Checker Inbox & Tasks", "fa fa-check-square-o", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Collection Sheet", "fa fa-tasks", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Individual Collection Sheet", "fa fa-tasks", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Frequent Postings", "fa fa-pencil-square-o", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Add Journal Entries", "fa fa-pencil-square-o", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Closing Entries", "fa fa-folder", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Chart of Accounts", "fa fa-sitemap", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Client", "fa fa-user-plus", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Group", "fa fa-user-plus", HomePage.class, new PageParameters()));
        sidebars.add(new SidebarWidget.Sidebar(false, "Center", "fa fa-user-plus", HomePage.class, new PageParameters()));
        return sidebars;
    }

    protected List<MenuWidget.Menu> buildClientMenu() {
        List<MenuWidget.Menu> menus = new ArrayList<>();
        menus.add(new MenuWidget.Menu(false, "Clients", "fa fa-users", ClientBrowsePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Groups", "fa fa-users", GroupBrowsePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Centers", "fa fa-users", CenterBrowsePage.class, new PageParameters()));
        return menus;
    }

    protected List<MenuWidget.Menu> buildReportMenu() {
        List<MenuWidget.Menu> menus = new ArrayList<>();
        menus.add(new MenuWidget.Menu(false, "All", "fa fa-area-chart", HomePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Clients", "fa fa-users", HomePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Loans", "fa fa-money", HomePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Savings", "fa fa-money", HomePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Funds", "fa fa-money", HomePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Accounting", "fa fa-bank", HomePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "XBRL", "fa fa-pie-chart", HomePage.class, new PageParameters()));
        return menus;
    }

    protected List<MenuWidget.Menu> buildAdminMenu() {
        List<MenuWidget.Menu> menus = new ArrayList<>();
        menus.add(new MenuWidget.Menu(false, "Users", "fa fa-users", HomePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Organization", "fa fa-building-o", OrganizationPage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "System", "fa fa-cogs", SystemPage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Products", "fa fa-briefcase", ProductPage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Templates", "fa fa-book", HomePage.class, new PageParameters()));
        return menus;
    }

    protected List<MenuWidget.Menu> buildKhmerMFMenu() {
        List<MenuWidget.Menu> menus = new ArrayList<>();
        menus.add(new MenuWidget.Menu(false, "Profile", "fa fa-user", HomePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Settings", "fa fa-cogs", HomePage.class, new PageParameters()));
        menus.add(new MenuWidget.Menu(false, "Sign Out", "fa fa-power-off", HomePage.class, new PageParameters()));
        return menus;
    }

}
