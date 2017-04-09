package com.angkorteam.finance.server.layout;

import com.angkorteam.finance.server.widget.TabbedWidget;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public abstract class TabbedPage extends MasterPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MasterPage.class);

    private RepeatingView tabbedItemWidget;

    public TabbedPage() {
    }

    public TabbedPage(IModel<?> model) {
        super(model);
    }

    public TabbedPage(PageParameters parameters) {
        super(parameters);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        List<TabbedWidget.Tabbed> tabbed = buildTabbed();

        this.tabbedItemWidget = new RepeatingView("tabbedItemWidget");
        add(this.tabbedItemWidget);

        for (TabbedWidget.Tabbed item : tabbed == null ? new ArrayList<TabbedWidget.Tabbed>() : tabbed) {
            String id = this.tabbedItemWidget.newChildId();
            TabbedWidget tabbedWidget = new TabbedWidget(id, item);
            if (item.isActive()) {
                tabbedWidget.add(AttributeModifier.replace("class", "active"));
            }
            this.tabbedItemWidget.add(tabbedWidget);
        }

    }

    protected List<TabbedWidget.Tabbed> buildTabbed() {
        return null;
    }

}