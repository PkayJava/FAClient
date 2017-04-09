package com.angkorteam.finance.server.page.admin;

import com.angkorteam.finance.faclient.SystemService;
import com.angkorteam.finance.faclient.dto.system.Office;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.layout.MasterPage;
import com.angkorteam.finance.server.provider.OfficeProvider;
import com.angkorteam.finance.server.widget.BreadcrumbWidget;
import com.angkorteam.framework.wicket.extensions.markup.html.repeater.data.table.DataTable;
import com.angkorteam.framework.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import com.angkorteam.framework.wicket.extensions.markup.html.repeater.data.table.filter.ActionFilterColumn;
import com.angkorteam.framework.wicket.extensions.markup.html.repeater.data.table.filter.ActionItem;
import com.google.common.collect.Lists;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.LambdaColumn;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by socheatkhauv on 4/8/17.
 */
@AuthorizeInstantiation("Super user")
public class OfficeBrowsePage extends MasterPage {

    private DataTable<Office, String> dataTable;

    @Override
    protected void doInitialize(Border layout) {
        add(layout);

        SystemService systemService = Platform.getBean(SystemService.class);
        Call<List<Office>> call = systemService.officeList();
        Response<List<Office>> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
        }

        OfficeProvider provider = null;
        if (response.body() != null) {
            provider = new OfficeProvider(response.body());
        } else {
            provider = new OfficeProvider(new ArrayList<>());
        }

        List<IColumn<Office, String>> columns = new ArrayList<>();
        columns.add(new LambdaColumn<>(Model.of("Office Name"), this::officeName));
        columns.add(new LambdaColumn<>(Model.of("External ID"), this::officeExternalId));
        columns.add(new LambdaColumn<>(Model.of("Parent Office"), this::officeParent));
        columns.add(new LambdaColumn<>(Model.of("Opened On"), this::openedOn));
        columns.add(new ActionFilterColumn<>(Model.of("action"), this::actions, this::itemClick));

        this.dataTable = new DefaultDataTable<>("table", columns, provider, 100);
        layout.add(this.dataTable);

        BookmarkablePageLink<Void> newOfficeLink = new BookmarkablePageLink<>("newOfficeLink", OfficeCreatePage.class);
        layout.add(newOfficeLink);
    }

    protected Object officeName(Office office) {
        return office.getName();
    }

    protected Object officeExternalId(Office office) {
        return office.getExternalId();
    }

    protected Object officeParent(Office office) {
        return office.getParentName();
    }

    protected Object openedOn(Office office) {
        if (office.getOpeningDate() != null && !office.getOpeningDate().isEmpty()) {
            return office.getOpeningDate().get(0) + "/" + office.getOpeningDate().get(1) + "/" + office.getOpeningDate().get(2);
        } else {
            return "";
        }
    }

    @Override
    protected List<BreadcrumbWidget.Breadcrumb> buildBreadcrumb() {
        return null;
    }

    private void itemClick(String link, Office object, AjaxRequestTarget target) {
        if ("Edit".equals(link)) {
        }
    }

    private List<ActionItem> actions(String name, Office object) {
        List<ActionItem> actionItems = Lists.newArrayList();
        actionItems.add(new ActionItem("Edit", Model.of("Edit")));
        return actionItems;
    }

}
