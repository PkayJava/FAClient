package com.angkorteam.finance.server.page.client;

import com.angkorteam.finance.faclient.GroupService;
import com.angkorteam.finance.faclient.dto.group.Center;
import com.angkorteam.finance.faclient.dto.group.CenterListResponse;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.layout.MasterPage;
import com.angkorteam.finance.server.provider.CenterProvider;
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
public class CenterBrowsePage extends MasterPage {

    private DataTable<Center, String> dataTable;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        GroupService groupService = Platform.getBean(GroupService.class);
        Call<CenterListResponse> call = groupService.centerList(0, 100);
        Response<CenterListResponse> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
        }

        CenterProvider provider = null;
        if (response.body() != null) {
            provider = new CenterProvider(response.body().getPageItems());
        } else {
            provider = new CenterProvider(new ArrayList<>());
        }

        List<IColumn<Center, String>> columns = new ArrayList<>();
        columns.add(new LambdaColumn<>(Model.of("Name"), this::groupName));
        columns.add(new LambdaColumn<>(Model.of("Account#"), this::groupAccountNo));
        columns.add(new LambdaColumn<>(Model.of("External ID"), this::groupExternalId));
        columns.add(new LambdaColumn<>(Model.of("Status"), this::groupStatus));
        columns.add(new LambdaColumn<>(Model.of("Office"), this::groupOffice));
        columns.add(new ActionFilterColumn<>(Model.of("action"), this::actions, this::itemClick));

        this.dataTable = new DefaultDataTable<>("table", columns, provider, 100);
        add(this.dataTable);
    }

    protected Object groupName(Center center) {
        return center.getName();
    }

    protected Object groupAccountNo(Center center) {
        return center.getAccountNo();
    }

    protected Object groupExternalId(Center center) {
        return center.getExternalId();
    }

    protected Object groupStatus(Center center) {
        return center.getStatus().getValue();
    }

    protected Object groupOffice(Center center) {
        return center.getOfficeName();
    }

    @Override
    protected List<BreadcrumbWidget.Breadcrumb> buildBreadcrumb() {
        return null;
    }

    private void itemClick(String link, Center object, AjaxRequestTarget target) {
        if ("Edit".equals(link)) {
        }
    }

    private List<ActionItem> actions(String name, Center object) {
        List<ActionItem> actionItems = Lists.newArrayList();
        actionItems.add(new ActionItem("Edit", Model.of("Edit")));
        return actionItems;
    }

}
