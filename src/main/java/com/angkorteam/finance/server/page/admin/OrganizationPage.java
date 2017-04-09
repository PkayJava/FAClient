package com.angkorteam.finance.server.page.admin;

import com.angkorteam.finance.server.layout.MasterPage;
import com.angkorteam.finance.server.page.HomePage;
import com.angkorteam.finance.server.widget.BreadcrumbWidget;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public class OrganizationPage extends MasterPage {

    @Override
    protected void initInterface() {
        BookmarkablePageLink<Void> officeBrowsePage = new BookmarkablePageLink<>("officeBrowsePage", OfficeBrowsePage.class);
        add(officeBrowsePage);
    }

    @Override
    protected List<BreadcrumbWidget.Breadcrumb> buildBreadcrumb() {
        List<BreadcrumbWidget.Breadcrumb> menus = new ArrayList<>();
        menus.add(new BreadcrumbWidget.Breadcrumb("Dashboard", "fa fa-dashboard", HomePage.class, new PageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb("Organization", null, OrganizationPage.class, new PageParameters()));
        return menus;
    }
}
