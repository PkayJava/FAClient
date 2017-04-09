package com.angkorteam.finance.server.page.admin;

import com.angkorteam.finance.faclient.SystemService;
import com.angkorteam.finance.faclient.dto.common.Feedback;
import com.angkorteam.finance.faclient.dto.system.DataTable;
import com.angkorteam.finance.faclient.dto.system.DataTableGenericResultSetResponse;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.layout.TabbedPage;
import com.angkorteam.finance.server.page.HomePage;
import com.angkorteam.finance.server.widget.*;
import com.angkorteam.framework.wicket.markup.html.form.Button;
import com.angkorteam.framework.wicket.markup.html.form.Form;
import com.angkorteam.framework.wicket.markup.html.form.select2.Option;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by socheatkhauv on 4/9/17.
 */
@AuthorizeInstantiation("Super user")
public class OfficePreviewSingleModifyExtraPage extends TabbedPage {

    private Long officeId;

    private String appTable;

    private String officeName;

    private List<DataTable> dataTables;

    private DataTableGenericResultSetResponse body;

    private Map<String, Object> domainValue;

    private Map<String, List<Option>> options;

    private Form<Void> form;
    private BookmarkablePageLink<Void> cancelButton;
    private Button submitButton;

    private static SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private boolean create = false;

    @Override
    protected void initData(PageParameters parameters) throws Throwable {
        super.initData(parameters);
        this.officeId = parameters.get("officeId").toLong();
        this.appTable = parameters.get("appTable").toString();
        this.officeName = parameters.get("officeName").toString();

        SystemService systemService = Platform.getBean(SystemService.class);
        {
            Call<DataTableGenericResultSetResponse> call = systemService.dataTableAppTableResultSet(appTable, officeId);
            Response<DataTableGenericResultSetResponse> response = call.execute();
            this.body = response.body();
        }

        {
            Call<List<DataTable>> call = systemService.dataTableList("m_office");
            Response<List<DataTable>> response = call.execute();
            this.dataTables = response.body();
        }

        this.options = new HashMap<>();
        this.domainValue = new HashMap<>();

        if (body.getData() != null && !body.getData().isEmpty()) {
            DataTableGenericResultSetResponse.Record record = body.getData().get(0);
            for (int i = 0; i < record.getRow().size(); i++) {
                Object object = record.getRow().get(i);
                DataTableGenericResultSetResponse.ColumnHeader header = body.getColumnHeaders().get(i);
                String columnName = header.getColumnName();
                if ("CODELOOKUP".equals(header.getColumnDisplayType())) {
                    List<Option> options = new ArrayList<>();
                    for (DataTableGenericResultSetResponse.ColumnValue columnValue : header.getColumnValues()) {
                        Option option = new Option(String.valueOf(columnValue.getId()), columnValue.getValue());
                        options.add(option);
                    }
                    this.options.put(columnName, options);
                }
                this.domainValue.put(columnName, object);
            }
            this.create = false;
        } else {
            for (int i = 0; i < body.getColumnHeaders().size(); i++) {
                DataTableGenericResultSetResponse.ColumnHeader header = body.getColumnHeaders().get(i);
                String columnName = header.getColumnName();
                if ("CODELOOKUP".equals(header.getColumnDisplayType())) {
                    List<Option> options = new ArrayList<>();
                    for (DataTableGenericResultSetResponse.ColumnValue columnValue : header.getColumnValues()) {
                        Option option = new Option(String.valueOf(columnValue.getId()), columnValue.getValue());
                        options.add(option);
                    }
                    this.options.put(columnName, options);
                }
                this.domainValue.put(columnName, null);
            }
            this.create = true;
        }
        this.domainValue.remove("office_id");
    }

    @Override
    protected void initInterface() throws Throwable {
        super.initInterface();

        this.form = new Form<>("form");
        add(this.form);

        RepeatingView fields = new RepeatingView("fields");
        this.form.add(fields);

        for (DataTableGenericResultSetResponse.ColumnHeader header : this.body.getColumnHeaders()) {
            String columnName = header.getColumnName();
            if (columnName.equals("office_id")) {
                continue;
            }
            String value = (String) this.domainValue.get(columnName);
            if (header.getColumnDisplayType().equals("DATETIME")) {
                String newChildId = fields.newChildId();
                try {
                    this.domainValue.put(columnName, Strings.isNullOrEmpty(value) ? null : datetimeFormat.parse(value));
                } catch (ParseException e) {
                    this.domainValue.put(columnName, null);
                }
                ModifyDateTimeFieldWidget widget = new ModifyDateTimeFieldWidget(newChildId, columnName, header, this.domainValue);
                fields.add(widget);
            } else if (header.getColumnDisplayType().equals("DATE")) {
                String newChildId = fields.newChildId();
                try {
                    this.domainValue.put(columnName, Strings.isNullOrEmpty(value) ? null : dateFormat.parse(value));
                } catch (ParseException e) {
                    this.domainValue.put(columnName, null);
                }
                ModifyDateFieldWidget widget = new ModifyDateFieldWidget(newChildId, columnName, header, this.domainValue);
                fields.add(widget);
            } else if (header.getColumnDisplayType().equals("BOOLEAN")) {
                String newChildId = fields.newChildId();
                this.domainValue.put(columnName, Strings.isNullOrEmpty(value) ? false : Boolean.valueOf(value));
                ModifyBooleanFieldWidget widget = new ModifyBooleanFieldWidget(newChildId, columnName, header, this.domainValue);
                fields.add(widget);
            } else if (header.getColumnDisplayType().equals("INTEGER")) {
                String newChildId = fields.newChildId();
                try {
                    this.domainValue.put(columnName, Strings.isNullOrEmpty(value) ? null : Long.valueOf(value));
                } catch (NumberFormatException e) {
                    this.domainValue.put(columnName, null);
                }
                ModifyNumberFieldWidget widget = new ModifyNumberFieldWidget(newChildId, columnName, header, this.domainValue);
                fields.add(widget);
            } else if (header.getColumnDisplayType().equals("STRING")) {
                String newChildId = fields.newChildId();
                this.domainValue.put(columnName, Strings.isNullOrEmpty(value) ? null : value);
                ModifyStringFieldWidget widget = new ModifyStringFieldWidget(newChildId, columnName, header, this.domainValue);
                fields.add(widget);
            } else if (header.getColumnDisplayType().equals("DECIMAL")) {
                String newChildId = fields.newChildId();
                try {
                    this.domainValue.put(columnName, Strings.isNullOrEmpty(value) ? null : Double.valueOf(value));
                } catch (NumberFormatException e) {
                    this.domainValue.put(columnName, null);
                }
                ModifyDecimalFieldWidget widget = new ModifyDecimalFieldWidget(newChildId, columnName, header, this.domainValue);
                fields.add(widget);
            } else if (header.getColumnDisplayType().equals("TEXT")) {
                String newChildId = fields.newChildId();
                this.domainValue.put(columnName, Strings.isNullOrEmpty(value) ? null : value);
                ModifyTextFieldWidget widget = new ModifyTextFieldWidget(newChildId, columnName, header, this.domainValue);
                fields.add(widget);
            } else if (header.getColumnDisplayType().equals("CODELOOKUP")) {
                String newChildId = fields.newChildId();
                Option option = null;
                for (Option t : this.options.get(columnName)) {
                    if (t.getId().equals(value)) {
                        option = t;
                        break;
                    }
                }
                this.domainValue.put(columnName, option);
                ModifyDropdownFieldWidget widget = new ModifyDropdownFieldWidget(newChildId, columnName, header, this.options.get(columnName), this.domainValue);
                fields.add(widget);
            }
        }

        this.cancelButton = new BookmarkablePageLink<>("cancelButton", OfficePreviewSinglePreviewExtraPage.class, getPageParameters());
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
        menus.add(new BreadcrumbWidget.Breadcrumb(this.officeName, null, OfficePreviewPage.class, getPageParameters()));
        PageParameters parameters = new PageParameters();
        parameters.add("officeId", this.officeId);
        parameters.add("appTable", this.appTable);
        parameters.add("officeName", this.officeName);
        menus.add(new BreadcrumbWidget.Breadcrumb(this.appTable, null, OfficePreviewSingleModifyExtraPage.class, parameters));
        return menus;
    }

    @Override
    protected List<TabbedWidget.Tabbed> buildTabbed() {
        List<TabbedWidget.Tabbed> tabbed = new ArrayList<>();
        tabbed.add(new TabbedWidget.Tabbed(false, "General", null, OfficePreviewPage.class, getPageParameters()));
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
                parameters.add("officeId", this.officeId);
                parameters.add("appTable", dataTable.getRegisteredTableName());
                parameters.add("officeName", this.officeName);
                tabbed.add(new TabbedWidget.Tabbed(this.appTable.equals(dataTable.getRegisteredTableName()), dataTable.getRegisteredTableName(), null, OfficePreviewSingleModifyExtraPage.class, parameters));
            }
        }
        return tabbed;
    }

    protected void submitButtonSubmit(Button button) {
        Gson gson = Platform.getBean(Gson.class);
        SystemService systemService = Platform.getBean(SystemService.class);
        Map<String, Object> newRecord = new HashMap<>();
        for (Map.Entry<String, Object> item : this.domainValue.entrySet()) {
            if (item.getValue() instanceof Date) {
                newRecord.put(item.getKey(), datetimeFormat.format((Date) item.getValue()));
            } else if (item.getValue() instanceof Option) {
                newRecord.put(item.getKey(), ((Option) item.getValue()).getId());
            } else {
                newRecord.put(item.getKey(), item.getValue());
            }
        }
        newRecord.put("locale", "en");
        newRecord.put("dateFormat", "yyyy-MM-dd HH:mm:ss.S");
        Call<Map<String, Object>> call = null;
        if (this.create) {
            call = systemService.dataTableAppTableResultSetCreate(this.appTable, this.officeId, newRecord);
        } else {
            call = systemService.dataTableAppTableResultSetUpdate(this.appTable, this.officeId, newRecord);
        }
        try {
            Response<Map<String, Object>> response = call.execute();
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
