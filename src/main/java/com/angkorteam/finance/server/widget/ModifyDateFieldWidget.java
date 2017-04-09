package com.angkorteam.finance.server.widget;

import com.angkorteam.finance.faclient.dto.system.DataTableGenericResultSetResponse;
import com.angkorteam.framework.wicket.markup.html.form.DateTextField;
import com.angkorteam.framework.wicket.markup.html.panel.TextFeedbackPanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.Map;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public class ModifyDateFieldWidget extends Panel {

    private String labelValue;

    private Map<String, Object> domainValue;

    private DataTableGenericResultSetResponse.ColumnHeader columnHeader;

    public ModifyDateFieldWidget(String id, String labelValue, DataTableGenericResultSetResponse.ColumnHeader columnHeader, Map<String, Object> domainValue) {
        super(id);
        this.labelValue = labelValue;
        this.domainValue = domainValue;
        this.columnHeader = columnHeader;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Label labelField = new Label("labelField", this.labelValue);
        add(labelField);

        DateTextField uiField = new DateTextField("uiField", new PropertyModel<>(this.domainValue, this.labelValue));
        uiField.setRequired(!this.columnHeader.isColumnNullable());
        uiField.setLabel(Model.of(this.labelValue));
        add(uiField);

        TextFeedbackPanel uiFeedback = new TextFeedbackPanel("uiFeedback", uiField);
        add(uiFeedback);

    }
}
