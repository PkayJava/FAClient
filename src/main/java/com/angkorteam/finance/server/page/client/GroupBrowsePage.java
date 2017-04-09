package com.angkorteam.finance.server.page.client;

import com.angkorteam.finance.faclient.GroupService;
import com.angkorteam.finance.faclient.dto.group.Group;
import com.angkorteam.finance.faclient.dto.group.GroupListResponse;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.layout.MasterPage;
import com.angkorteam.finance.server.provider.GroupProvider;
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
import org.apache.wicket.request.mapper.parameter.PageParameters;
import retrofit2.Call;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by socheatkhauv on 4/8/17.
 */
@AuthorizeInstantiation("Super user")
public class GroupBrowsePage extends MasterPage {

    private DataTable<Group, String> dataTable;

    private GroupProvider provider = null;

    @Override
    protected void initData(PageParameters parameters) throws Throwable {
        super.initData(parameters);

        GroupService groupService = Platform.getBean(GroupService.class);
        Call<GroupListResponse> call = groupService.groupList(0, 100);
        Response<GroupListResponse> response = call.execute();

        if (response.body() != null) {
            provider = new GroupProvider(response.body().getPageItems());
        } else {
            provider = new GroupProvider(new ArrayList<>());
        }
    }

    @Override
    protected void initInterface() {
        super.initInterface();
        List<IColumn<Group, String>> columns = new ArrayList<>();
        columns.add(new LambdaColumn<>(Model.of("Name"), this::groupName));
        columns.add(new LambdaColumn<>(Model.of("Account#"), this::groupAccountNo));
        columns.add(new LambdaColumn<>(Model.of("External ID"), this::groupExternalId));
        columns.add(new LambdaColumn<>(Model.of("Status"), this::groupStatus));
        columns.add(new LambdaColumn<>(Model.of("Office"), this::groupOffice));
        columns.add(new ActionFilterColumn<>(Model.of("action"), this::actions, this::itemClick));

        this.dataTable = new DefaultDataTable<>("table", columns, provider, 100);
        add(this.dataTable);
    }

    protected Object groupName(Group group) {
        return group.getName();
    }

    protected Object groupAccountNo(Group group) {
        return group.getAccountNo();
    }

    protected Object groupExternalId(Group group) {
        return group.getExternalId();
    }

    protected Object groupStatus(Group group) {
        return group.getStatus().getValue();
    }

    protected Object groupOffice(Group group) {
        return group.getOfficeName();
    }

    @Override
    protected List<BreadcrumbWidget.Breadcrumb> buildBreadcrumb() {
        return null;
    }

    private void itemClick(String link, Group object, AjaxRequestTarget target) {
        if ("Edit".equals(link)) {
        }
    }

    private List<ActionItem> actions(String name, Group object) {
        List<ActionItem> actionItems = Lists.newArrayList();
        actionItems.add(new ActionItem("Edit", Model.of("Edit")));
        return actionItems;
    }

}
