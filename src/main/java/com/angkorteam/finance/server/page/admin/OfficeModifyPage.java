package com.angkorteam.finance.server.page.admin;

import com.angkorteam.finance.faclient.SystemService;
import com.angkorteam.finance.faclient.dto.common.Feedback;
import com.angkorteam.finance.faclient.dto.system.Office;
import com.angkorteam.finance.faclient.dto.system.OfficeCreate;
import com.angkorteam.finance.faclient.dto.system.OfficeCreateResponse;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.layout.MasterPage;
import com.angkorteam.finance.server.page.HomePage;
import com.angkorteam.finance.server.provider.OfficeChoiceProvider;
import com.angkorteam.finance.server.widget.BreadcrumbWidget;
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
public class OfficeModifyPage extends MasterPage {

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
    private Button createButton;
    private BookmarkablePageLink<Void> cancelButton;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        SystemService systemService = Platform.getBean(SystemService.class);
        Call<List<Office>> call = systemService.officeList();
        Response<List<Office>> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
        }

        this.form = new Form<>("form");
        add(this.form);

        this.externalValue = Platform.uuid();
        this.externalField = new TextField<>("externalField", new PropertyModel<>(this, "externalValue"));
        this.externalField.setLabel(Model.of("External ID"));
        this.form.add(this.externalField);
        this.externalFeedback = new TextFeedbackPanel("externalFeedback", this.externalField);
        this.form.add(this.externalFeedback);

        this.officeField = new TextField<>("officeField", new PropertyModel<>(this, "officeValue"));
        this.officeField.setLabel(Model.of("Office"));
        this.form.add(this.officeField);
        this.officeField.setRequired(true);
        this.officeFeedback = new TextFeedbackPanel("officeFeedback", this.officeField);
        this.form.add(this.officeFeedback);

        for (Office office : response.body()) {
            if (office.getId() == 1) {
                this.parentValue = new Option(String.valueOf(office.getId()), office.getName());
                break;
            }
        }
        this.parentField = new Select2SingleChoice<>("parentField", new PropertyModel<>(this, "parentValue"), new OfficeChoiceProvider(response.body()));
        this.parentField.setLabel(Model.of("Parent Office"));
        this.parentField.setRequired(true);
        this.form.add(this.parentField);
        this.parentFeedback = new TextFeedbackPanel("parentFeedback", this.parentField);
        this.form.add(this.parentFeedback);

        this.openedOnValue = new Date();
        this.openedOnField = new DateTextField("openedOnField", new PropertyModel<>(this, "openedOnValue"));
        this.openedOnField.setRequired(true);
        this.form.add(this.openedOnField);
        this.openedOnFeedback = new TextFeedbackPanel("openedOnFeedback", this.openedOnField);
        this.form.add(this.openedOnFeedback);

        this.cancelButton = new BookmarkablePageLink<>("cancelButton", OfficeBrowsePage.class);
        this.form.add(this.cancelButton);

        this.createButton = new Button("createButton");
        this.form.add(this.createButton);
        this.createButton.setOnSubmit(this::createButtonSubmit);

    }

    @Override
    protected List<BreadcrumbWidget.Breadcrumb> buildBreadcrumb() {
        List<BreadcrumbWidget.Breadcrumb> menus = new ArrayList<>();
        menus.add(new BreadcrumbWidget.Breadcrumb("Dashboard", "fa fa-dashboard", HomePage.class, new PageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb("Organization", null, OrganizationPage.class, new PageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb("Manage Offices", null, OfficeBrowsePage.class, new PageParameters()));
        menus.add(new BreadcrumbWidget.Breadcrumb("New Office", null, OfficeModifyPage.class, new PageParameters()));
        return menus;
    }

    protected void createButtonSubmit(Button button) {
        Gson gson = Platform.getBean(Gson.class);
        SimpleDateFormat dateFormat = new SimpleDateFormat(this.openedOnField.getTextFormat());
        SystemService systemService = Platform.getBean(SystemService.class);
        OfficeCreate office = new OfficeCreate();
        office.setName(this.officeValue);
        office.setExternalId(this.externalValue);
        office.setLocale("en");
        office.setDateFormat(this.openedOnField.getTextFormat());
        office.setParentId(Long.valueOf(this.parentValue.getId()));
        office.setOpeningDate(dateFormat.format(new Date()));
        Call<OfficeCreateResponse> call = systemService.officeCreate(office);
        try {
            Response<OfficeCreateResponse> response = call.execute();
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
