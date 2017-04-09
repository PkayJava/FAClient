package com.angkorteam.finance.server.provider;

import com.angkorteam.finance.faclient.dto.client.Client;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Iterator;
import java.util.List;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class ClientProvider extends SortableDataProvider<Client, String> {

    private List<Client> clients;

    public ClientProvider(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public Iterator<? extends Client> iterator(long first, long count) {
        return this.clients.iterator();
    }

    @Override
    public long size() {
        return this.clients.size();
    }

    @Override
    public IModel<Client> model(Client object) {
        return Model.of(object);
    }

}
