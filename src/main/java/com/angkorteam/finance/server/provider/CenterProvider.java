package com.angkorteam.finance.server.provider;

import com.angkorteam.finance.faclient.dto.group.Center;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Iterator;
import java.util.List;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class CenterProvider extends SortableDataProvider<Center, String> {

    private List<Center> centers;

    public CenterProvider(List<Center> centers) {
        this.centers = centers;
    }

    @Override
    public Iterator<? extends Center> iterator(long first, long count) {
        return this.centers.iterator();
    }

    @Override
    public long size() {
        return this.centers.size();
    }

    @Override
    public IModel<Center> model(Center object) {
        return Model.of(object);
    }

}
