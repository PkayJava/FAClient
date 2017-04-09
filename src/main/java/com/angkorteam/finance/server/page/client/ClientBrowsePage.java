package com.angkorteam.finance.server.page.client;

import com.angkorteam.finance.faclient.ClientService;
import com.angkorteam.finance.faclient.dto.client.Client;
import com.angkorteam.finance.faclient.dto.client.ClientListResponse;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.layout.MasterPage;
import com.angkorteam.finance.server.provider.ClientProvider;
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
public class ClientBrowsePage extends MasterPage {

    private DataTable<Client, String> dataTable;

    private ClientProvider provider;

    @Override
    protected void initData(PageParameters parameters) throws Throwable {
        super.initData(parameters);
        ClientService clientService = Platform.getBean(ClientService.class);
        Call<ClientListResponse> call = clientService.clientList(0, 5);
        Response<ClientListResponse> response = call.execute();
        if (response.body() != null) {
            provider = new ClientProvider(response.body().getPageItems());
        } else {
            provider = new ClientProvider(new ArrayList<>());
        }
    }

    @Override
    protected void initInterface() throws Throwable {
        super.initInterface();
        List<IColumn<Client, String>> columns = new ArrayList<>();
        columns.add(new LambdaColumn<>(Model.of("Name"), this::clientName));
        columns.add(new LambdaColumn<>(Model.of("Client#"), this::clientAccountNo));
        columns.add(new LambdaColumn<>(Model.of("External ID"), this::clientExternalId));
        columns.add(new LambdaColumn<>(Model.of("Status"), this::clientStatus));
        columns.add(new LambdaColumn<>(Model.of("Office"), this::clientOffice));
        columns.add(new ActionFilterColumn<>(Model.of("action"), this::actions, this::itemClick));

        this.dataTable = new DefaultDataTable<>("table", columns, provider, 100);
        add(this.dataTable);
    }

    protected Object clientName(Client client) {
        return client.getDisplayName();
    }

    protected Object clientAccountNo(Client client) {
        return client.getAccountNo();
    }

    protected Object clientExternalId(Client client) {
        return client.getExternalId();
    }

    protected Object clientStatus(Client client) {
        return client.getStatus().getValue();
    }

    protected Object clientOffice(Client client) {
        return client.getOfficeName();
    }

    @Override
    protected List<BreadcrumbWidget.Breadcrumb> buildBreadcrumb() {
        return null;
    }

    private void itemClick(String link, Client object, AjaxRequestTarget target) {
        if ("Edit".equals(link)) {
        }
    }

    private List<ActionItem> actions(String name, Client object) {
        List<ActionItem> actionItems = Lists.newArrayList();
        actionItems.add(new ActionItem("Edit", Model.of("Edit")));
        return actionItems;
    }

}
