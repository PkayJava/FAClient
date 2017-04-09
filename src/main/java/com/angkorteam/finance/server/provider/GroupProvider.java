package com.angkorteam.finance.server.provider;

import com.angkorteam.finance.faclient.dto.group.Group;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.Iterator;
import java.util.List;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class GroupProvider extends SortableDataProvider<Group, String> {

    private List<Group> groups;

    public GroupProvider(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public Iterator<? extends Group> iterator(long first, long count) {
        return this.groups.iterator();
    }

    @Override
    public long size() {
        return this.groups.size();
    }

    @Override
    public IModel<Group> model(Group object) {
        return Model.of(object);
    }

}
