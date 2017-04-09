package com.angkorteam.finance.server.page.admin;

import com.angkorteam.finance.faclient.SystemService;
import com.angkorteam.finance.faclient.dto.common.Feedback;
import com.angkorteam.finance.faclient.dto.system.DataTable;
import com.angkorteam.finance.faclient.dto.system.Office;
import com.angkorteam.finance.faclient.dto.system.OfficeUpdate;
import com.angkorteam.finance.faclient.dto.system.OfficeUpdateResponse;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.layout.TabbedPage;
import com.angkorteam.finance.server.page.HomePage;
import com.angkorteam.finance.server.provider.OfficeChoiceProvider;
import com.angkorteam.finance.server.widget.BreadcrumbWidget;
import com.angkorteam.finance.server.widget.TabbedWidget;
import com.angkorteam.framework.wicket.markup.html.form.Button;
import com.angkorteam.framework.wicket.markup.html.form.DateTextField;
import com.angkorteam.framework.wicket.markup.html.form.Form;
import com.angkorteam.framework.wicket.markup.html.form.select2.Option;
import com.angkorteam.framework.wicket.markup.html.form.select2.Select2SingleChoice;
import com.angkorteam.framework.wicket.markup.html.panel.TextFeedbackPanel;
import com.google.gson.Gson;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.joda.time.LocalDate;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by socheatkhauv on 4/9/17.
 */
@AuthorizeInstantiation("Super user")
public class OfficeModifyPage extends TabbedPage {

    private Long officeId;

    private String externalValue;
    private TextField<String> externalField;
    private TextFeedbackPanel externalFeedback;

    private String officeValue;
    private TextField<String> officeField;
    private TextFeedbackPanel officeFeedback;

    private Option parentValue;
    private Select2SingleChoice<Option> parentField;
    private TextFeedbackPanel parentFeedback;

    private Date openedOnValue;
    private DateTextField openedOnField;
    private TextFeedbackPanel openedOnFeedback;

    private Form<Void> form;
    private Button submitButton;
    private BookmarkablePageLink<Void> cancelButton;

    private List<Office> offices;
    private List<DataTable> dataTables;

    private Office office;

    @Override
    protected void initData(PageParameters parameters) throws Throwable {
        super.initData(parameters);
        this.officeId = parameters.get("officeId").toLong();

        SystemService systemService = Platform.getBean(SystemService.class);
        {
            Call<List<Office>> call = systemService.officeList();
            Response<List<Office>> response = call.execute();
            this.offices = response.body();
        }
        {
            Call<Office> call = systemService.officeRetrieve(this.officeId);
            Response<Office> response = call.execute();
            this.office = response.body();
        }
        {
            Call<List<DataTable>> call = systemService.dataTableList("m_office");
            Response<List<DataTable>> response = call.execute();
            this.dataTables = response.body();
        }
    }

    @Override
    protected void initInterface() throws Throwable {
        super.initInterface();
        this.form = new Form<>("form");
        add(this.form);

        this.externalValue = this.office.getExternalId();
        this.externalField = new TextField<>("externalField", new PropertyModel<>(this, "externalValue"));
        this.externalField.setLabel(Model.of("External ID"));
        this.form.add(this.externalField);
        this.externalFeedback = new TextFeedbackPanel("externalFeedback", this.externalField);
        this.form.add(this.externalFeedback);

        this.officeValue = this.office.getName();
        this.officeField = new TextField<>("officeField", new PropertyModel<>(this, "officeValue"));
        this.officeField.setLabel(Model.of("Office"));
        this.form.add(this.officeField);
        this.officeField.setRequired(true);
        this.officeFeedback = new TextFeedbackPanel("officeFeedback", this.officeField);
        this.form.add(this.officeFeedback);

        for (Office office : this.offices) {
            if (office.getId().equals(this.office.getId())) {
                this.parentValue = new Option(String.valueOf(office.getId()), office.getName());
                break;
            }
        }
        this.parentField = new Select2SingleChoice<>("parentField", new PropertyModel<>(this, "parentValue"), new OfficeChoiceProvider(this.offices));
        this.parentField.setLabel(Model.of("Parent Office"));
        this.parentField.setRequired(true);
        this.form.add(this.parentField);
        this.parentFeedback = new TextFeedbackPanel("parentFeedback", this.parentField);
        this.form.add(this.parentFeedback);

        if (this.office.getOpeningDate() != null) {
            this.openedOnValue = new LocalDate(this.office.getOpeningDate().get(0), this.office.getOpeningDate().get(1), this.office.getOpeningDate().get(2)).toDate();
        }
        this.openedOnField = new DateTextField("openedOnField", new PropertyModel<>(this, "openedOnValue"));
        this.openedOnField.setRequired(true);
        this.form.add(this.openedOnField);
        this.openedOnFeedback = new TextFeedbackPanel("openedOnFeedback", this.openedOnField);
        this.form.add(this.openedOnFeedback);

        this.cancelButton = new BookmarkablePageLink<>("cancelButton", OfficeBrowsePage.class);
        this.form.add(this.cancelButton);

        this.submitButton = new Button("submitButton");
        this.form.add(this.submitButton);
        this.submitButton.setOnSubmit(this::submitButtonSubmit);

    }

    @Override
    protected List<BreadcrumbWidget.Breadcrumb> buildBreadcrumb() {
        List<BreadcrumbWidget.Breadcrumb> menus = new ArrayList<>();
        menus.add(new BreadcrumbWidget.Breadcrumb("Dashboard", "fa fa-dashboard", HomePage.class, new PageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb("Organization", null, OrganizationPage.class, new PageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb("Manage Offices", null, OfficeBrowsePage.class, new PageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb(this.office.getName(), null, OfficePreviewPage.class, getPageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb("General", null, OfficePreviewPage.class, getPageParameters()));
        return menus;
    }

    @Override
    protected List<TabbedWidget.Tabbed> buildTabbed() {
        List<TabbedWidget.Tabbed> tabbed = new ArrayList<>();
        tabbed.add(new TabbedWidget.Tabbed(true, "General", null, OfficePreviewPage.class, getPageParameters()));
        for (DataTable dataTable : this.dataTables) {
            boolean single = true;
            for (DataTable.ColumnHeaderData columnHeaderData : dataTable.getColumnHeaderData()) {
                if (columnHeaderData.getColumnName().equals("office_id") && !columnHeaderData.isColumnPrimaryKey()) {
                    single = false;
                    break;
                }

            }
            if (single) {
                PageParameters parameters = new PageParameters();
                parameters.add("officeId", this.office.getId());
                parameters.add("officeName", this.office.getName());
                parameters.add("appTable", dataTable.getRegisteredTableName());
                tabbed.add(new TabbedWidget.Tabbed(false, dataTable.getRegisteredTableName(), null, OfficePreviewSinglePreviewExtraPage.class, parameters));
            }
        }
        return tabbed;
    }

    protected void submitButtonSubmit(Button button) {
        Gson gson = Platform.getBean(Gson.class);
        SimpleDateFormat dateFormat = new SimpleDateFormat(this.openedOnField.getTextFormat());
        SystemService systemService = Platform.getBean(SystemService.class);
        OfficeUpdate office = new OfficeUpdate();
        office.setName(this.officeValue);
        office.setExternalId(this.externalValue);
        office.setLocale("en");
        office.setDateFormat(this.openedOnField.getTextFormat());
        office.setParentId(Long.valueOf(this.parentValue.getId()));
        office.setOpeningDate(dateFormat.format(new Date()));
        Call<OfficeUpdateResponse> call = systemService.officeUpdate(this.officeId, office);
        try {
            Response<OfficeUpdateResponse> response = call.execute();
            if (!response.isSuccessful()) {
                Feedback feedback = gson.fromJson(response.errorBody().string(), Feedback.class);
                if (feedback != null && feedback.getErrors() != null) {
                    for (Feedback.Error error : feedback.getErrors()) {
                        error(error.getDefaultUserMessage());
                    }
                }
            } else {
                setResponsePage(OfficeBrowsePage.class);
            }
        } catch (IOException e) {
            info(e.getMessage());
        }
    }

}
