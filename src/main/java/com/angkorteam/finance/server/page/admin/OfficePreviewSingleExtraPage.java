package com.angkorteam.finance.server.page.admin;

import com.angkorteam.finance.faclient.SystemService;
import com.angkorteam.finance.faclient.dto.system.DataTable;
import com.angkorteam.finance.faclient.dto.system.DataTableGenericResultSetResponse;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.layout.TabbedPage;
import com.angkorteam.finance.server.page.HomePage;
import com.angkorteam.finance.server.widget.BreadcrumbWidget;
import com.angkorteam.finance.server.widget.DisplayFieldWidget;
import com.angkorteam.finance.server.widget.TabbedWidget;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import retrofit2.Call;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by socheatkhauv on 4/9/17.
 */
@AuthorizeInstantiation("Super user")
public class OfficePreviewSingleExtraPage extends TabbedPage {

    private Long officeId;

    private String appTable;

    private String officeName;

    private List<DataTable> dataTables;

    private DataTableGenericResultSetResponse body;

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
    }

    @Override
    protected void initInterface() {
        super.initInterface();

        RepeatingView fields = new RepeatingView("fields");
        add(fields);
        if (body.getData() != null && !body.getData().isEmpty()) {
            DataTableGenericResultSetResponse.Record record = body.getData().get(0);
            for (int i = 0; i < record.getRow().size(); i++) {
                String newChildId = fields.newChildId();
                Object object = record.getRow().get(i);
                DataTableGenericResultSetResponse.ColumnHeader header = body.getColumnHeaders().get(i);
                String columnName = header.getColumnName();
                if ("CODELOOKUP".equals(header.getColumnDisplayType())) {
                    columnName = columnName.substring(header.getColumnCode().length() + 4);
                }
                if (object == null) {
                    DisplayFieldWidget displayFieldWidget = new DisplayFieldWidget(newChildId, columnName, "");
                    fields.add(displayFieldWidget);
                } else {
                    DisplayFieldWidget displayFieldWidget = new DisplayFieldWidget(newChildId, columnName, object.toString());
                    fields.add(displayFieldWidget);
                }
            }
        } else {
            for (int i = 0; i < body.getColumnHeaders().size(); i++) {
                String newChildId = fields.newChildId();
                DataTableGenericResultSetResponse.ColumnHeader header = body.getColumnHeaders().get(i);
                String columnName = header.getColumnName();
                if ("CODELOOKUP".equals(header.getColumnDisplayType())) {
                    columnName = columnName.substring(header.getColumnCode().length() + 4);
                }
                DisplayFieldWidget displayFieldWidget = new DisplayFieldWidget(newChildId, columnName, "");
                fields.add(displayFieldWidget);
            }
        }
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
        menus.add(new BreadcrumbWidget.Breadcrumb(this.appTable, null, OfficePreviewSingleExtraPage.class, parameters));
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
                tabbed.add(new TabbedWidget.Tabbed(this.appTable.equals(dataTable.getRegisteredTableName()), dataTable.getRegisteredTableName(), null, OfficePreviewSingleExtraPage.class, parameters));
            }
        }
        return tabbed;
    }
}
