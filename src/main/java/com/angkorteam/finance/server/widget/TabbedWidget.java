package com.angkorteam.finance.server.widget;

import com.google.common.base.Strings;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public class TabbedWidget extends Panel {

    private Tabbed tabbed;

    public TabbedWidget(String id, Tabbed tabbed) {
        super(id);
        this.tabbed = tabbed;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        BookmarkablePageLink<Void> link = new BookmarkablePageLink<>("link", this.tabbed.getPageClass(), this.tabbed.getParameters());
        add(link);

        WebMarkupContainer icon = new WebMarkupContainer("icon");
        link.add(icon);
        icon.add(AttributeModifier.replace("class", this.tabbed.getIcon()));
        if (Strings.isNullOrEmpty(this.tabbed.getIcon())) {
            icon.setVisible(false);
        }

        Label label = new Label("text", this.tabbed.getLabel());
        link.add(label);
    }

    public static class Tabbed implements Serializable {

        private boolean active;

        private String label;

        private String icon;

        private Class<? extends Page> pageClass;

        private PageParameters parameters;

        public Tabbed(boolean active, String label, String icon, Class<? extends Page> pageClass, PageParameters parameters) {
            this.active = active;
            this.label = label;
            this.icon = icon;
            this.pageClass = pageClass;
            this.parameters = parameters;
        }

        public boolean isActive() {
            return active;
        }

        public String getLabel() {
            return label;
        }

        public String getIcon() {
            return icon;
        }

        public Class<? extends Page> getPageClass() {
            return pageClass;
        }

        public PageParameters getParameters() {
            return parameters;
        }
    }
}
