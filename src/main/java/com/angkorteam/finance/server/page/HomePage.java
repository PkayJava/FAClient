package com.angkorteam.finance.server.page;

import com.angkorteam.finance.server.layout.MasterPage;
import com.angkorteam.finance.server.widget.BreadcrumbWidget;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends MasterPage {


    @Override
    protected List<BreadcrumbWidget.Breadcrumb> buildBreadcrumb() {
        List<BreadcrumbWidget.Breadcrumb> menus = new ArrayList<>();
        menus.add(new BreadcrumbWidget.Breadcrumb("Dashboard", "fa fa-dashboard", HomePage.class, new PageParameters()));
        return menus;
    }
}
