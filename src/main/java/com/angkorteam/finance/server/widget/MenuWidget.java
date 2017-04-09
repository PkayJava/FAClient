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
public class MenuWidget extends Panel {

    private Menu menu;

    public MenuWidget(String id, Menu menu) {
        super(id);
        this.menu = menu;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        BookmarkablePageLink<Void> link = new BookmarkablePageLink<>("link", this.menu.getPageClass(), this.menu.getParameters());
        add(link);

        WebMarkupContainer icon = new WebMarkupContainer("icon");
        link.add(icon);
        icon.add(AttributeModifier.replace("class", this.menu.getIcon()));
        if (Strings.isNullOrEmpty(this.menu.getIcon())) {
            icon.setVisible(false);
        }

        Label label = new Label("text", this.menu.getLabel());
        link.add(label);
    }

    public static class Menu implements Serializable {

        private String label;

        private String icon;

        private Class<? extends Page> pageClass;

        private PageParameters parameters;

        public Menu(String label, String icon, Class<? extends Page> pageClass, PageParameters parameters) {
            this.label = label;
            this.icon = icon;
            this.pageClass = pageClass;
            this.parameters = parameters;
        }

        public Class<? extends Page> getPageClass() {
            return pageClass;
        }

        public PageParameters getParameters() {
            return parameters;
        }

        public String getLabel() {
            return label;
        }

        public String getIcon() {
            return icon;
        }
    }

}
