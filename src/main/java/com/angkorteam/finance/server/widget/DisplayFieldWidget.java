package com.angkorteam.finance.server.widget;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public class DisplayFieldWidget extends Panel {


    private String labelValue;
    private Label labelField;

    private String uiValue;
    private Label uiField;

    public DisplayFieldWidget(String id, String labelValue, String uiValue) {
        super(id);
        this.labelValue = labelValue;
        this.uiValue = uiValue;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.labelField = new Label("labelField", this.labelValue);
        add(this.labelField);

        this.uiField = new Label("uiField", this.uiValue);
        add(this.uiField);
    }
}
