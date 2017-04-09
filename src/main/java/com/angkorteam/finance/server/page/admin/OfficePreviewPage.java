package com.angkorteam.finance.server.page.admin;

import com.angkorteam.finance.faclient.SystemService;
import com.angkorteam.finance.faclient.dto.system.Office;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.layout.TabbedPage;
import com.angkorteam.finance.server.page.HomePage;
import com.angkorteam.finance.server.widget.BreadcrumbWidget;
import com.angkorteam.finance.server.widget.TabbedWidget;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by socheatkhauv on 4/9/17.
 */
@AuthorizeInstantiation("Super user")
public class OfficePreviewPage extends TabbedPage {

    private Long officeId;

    private String externalValue;
    private Label externalField;

    private String officeValue;
    private Label officeField;

    private String parentValue;
    private Label parentField;

    private String openedOnValue;
    private Label openedOnField;

    private WebMarkupContainer form;

    private Office office;

    @Override
    protected void initData(PageParameters parameters) {
        super.initData(parameters);
        this.officeId = getPageParameters().get("officeId").toLong();

        SystemService systemService = Platform.getBean(SystemService.class);
        Call<Office> call = systemService.officeRetrieve(this.officeId);
        Response<Office> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            error(e.getMessage());
        }
        this.office = response.body();
    }

    @Override
    protected void initInterface() {

        this.form = new WebMarkupContainer("form");
        add(this.form);

        this.externalValue = this.office.getExternalId();
        this.externalField = new Label("externalField", new PropertyModel<>(this, "externalValue"));
        this.form.add(this.externalField);

        this.officeValue = this.office.getName();
        this.officeField = new Label("officeField", new PropertyModel<>(this, "officeValue"));
        this.form.add(this.officeField);

        this.parentValue = this.office.getParentName();
        this.parentField = new Label("parentField", new PropertyModel<>(this, "parentValue"));
        this.form.add(this.parentField);


        this.openedOnValue = DateFormatUtils.format(new org.joda.time.LocalDate(this.office.getOpeningDate().get(0), this.office.getOpeningDate().get(1), this.office.getOpeningDate().get(2)).toDate(), "yyyy-MM-dd");
        this.openedOnField = new Label("openedOnField", new PropertyModel<>(this, "openedOnValue"));
        this.form.add(this.openedOnField);
    }

    @Override
    protected List<BreadcrumbWidget.Breadcrumb> buildBreadcrumb() {
        List<BreadcrumbWidget.Breadcrumb> menus = new ArrayList<>();
        menus.add(new BreadcrumbWidget.Breadcrumb("Dashboard", "fa fa-dashboard", HomePage.class, new PageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb("Organization", null, OrganizationPage.class, new PageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb("Manage Offices", null, OfficeBrowsePage.class, new PageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb(this.office.getName(), null, OfficePreviewPage.class, getPageParameters()));
        return menus;
    }

    @Override
    protected List<TabbedWidget.Tabbed> buildTabbed() {
        List<TabbedWidget.Tabbed> tabbed = new ArrayList<>();
        tabbed.add(new TabbedWidget.Tabbed(false, "General", null, OfficePreviewPage.class, getPageParameters()));
        tabbed.add(new TabbedWidget.Tabbed(true, "Document", null, OfficePreviewPage.class, getPageParameters()));
        return tabbed;
    }
}
