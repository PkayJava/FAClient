package com.angkorteam.finance.server.provider;

import com.angkorteam.finance.faclient.dto.system.Office;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Iterator;
import java.util.List;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class OfficeProvider extends SortableDataProvider<Office, String> {

    private List<Office> offices;

    public OfficeProvider(List<Office> offices) {
        this.offices = offices;
    }

    @Override
    public Iterator<? extends Office> iterator(long first, long count) {
        return this.offices.iterator();
    }

    @Override
    public long size() {
        return this.offices.size();
    }

    @Override
    public IModel<Office> model(Office object) {
        return Model.of(object);
    }

}
