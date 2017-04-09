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
public class BreadcrumbWidget extends Panel {

    private Breadcrumb breadcrumb;

    public BreadcrumbWidget(String id, Breadcrumb breadcrumb) {
        super(id);
        this.breadcrumb = breadcrumb;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        BookmarkablePageLink<Void> link = new BookmarkablePageLink<>("link", this.breadcrumb.getPageClass(), this.breadcrumb.getParameters());
        add(link);

        WebMarkupContainer icon = new WebMarkupContainer("icon");
        link.add(icon);
        icon.add(AttributeModifier.replace("class", this.breadcrumb.getIcon()));
        if (Strings.isNullOrEmpty(this.breadcrumb.getIcon())) {
            icon.setVisible(false);
        }

        Label label = new Label("text", this.breadcrumb.getLabel());
        link.add(label);
    }

    public static class Breadcrumb implements Serializable {

        private String label;

        private String icon;

        private Class<? extends Page> pageClass;

        private PageParameters parameters;

        public Breadcrumb(String label, String icon, Class<? extends Page> pageClass, PageParameters parameters) {
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
