package com.angkorteam.finance.server.widget;

import com.angkorteam.finance.faclient.dto.system.DataTableGenericResultSetResponse;
import com.angkorteam.framework.wicket.markup.html.form.OptionChoiceRenderer;
import com.angkorteam.framework.wicket.markup.html.form.select2.Option;
import com.angkorteam.framework.wicket.markup.html.panel.TextFeedbackPanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.List;
import java.util.Map;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public class ModifyDropdownFieldWidget extends Panel {

    private String labelValue;

    private Map<String, Object> domainValue;

    private DataTableGenericResultSetResponse.ColumnHeader columnHeader;

    private List<Option> options;

    public ModifyDropdownFieldWidget(String id, String labelValue, DataTableGenericResultSetResponse.ColumnHeader columnHeader, List<Option> options, Map<String, Object> domainValue) {
        super(id);
        this.labelValue = labelValue;
        this.domainValue = domainValue;
        this.columnHeader = columnHeader;
        this.options = options;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        Label labelField = new Label("labelField", Model.of(this.labelValue.substring(this.columnHeader.getColumnCode().length() + 4)));
        add(labelField);

        DropDownChoice<Option> uiField = new DropDownChoice<>("uiField", new PropertyModel<>(this.domainValue, this.labelValue), this.options, new OptionChoiceRenderer());
        uiField.setRequired(!this.columnHeader.isColumnNullable());
        uiField.setLabel(Model.of(this.labelValue.substring(this.columnHeader.getColumnCode().length() + 4)));
        add(uiField);

        TextFeedbackPanel uiFeedback = new TextFeedbackPanel("uiFeedback", uiField);
        add(uiFeedback);

    }
}
