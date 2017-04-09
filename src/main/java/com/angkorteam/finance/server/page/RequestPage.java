package com.angkorteam.finance.server.page;

import com.angkorteam.framework.jdbc.InsertQuery;
import com.angkorteam.framework.spring.JdbcNamed;
import com.angkorteam.framework.wicket.AdminLTEPage;
import com.angkorteam.framework.wicket.markup.html.form.Button;
import com.angkorteam.framework.wicket.markup.html.panel.TextFeedbackPanel;
import com.angkorteam.finance.server.Platform;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.validation.validator.RangeValidator;

import java.util.Date;

public class RequestPage extends AdminLTEPage {

    private StatelessForm<Void> form;

    private String titleValue;
    private TextField<String> titleField;
    private TextFeedbackPanel titleFeedback;

    private Integer maxFileSizeValue;
    private TextField<Integer> maxFileSizeField;
    private TextFeedbackPanel maxFileSizeFeedback;

    private Integer maxFileQuantityValue;
    private TextField<Integer> maxFileQuantityField;
    private TextFeedbackPanel maxFileQuantityFeedback;

    private Button requestButton;
    private BookmarkablePageLink<Void> cancelButton;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        this.form = new StatelessForm<>("form");
        add(this.form);

        this.titleField = new TextField<>("titleField", new PropertyModel<>(this, "titleValue"));
        this.titleField.setLabel(Model.of("Title"));
        this.form.add(this.titleField);
        this.titleField.setRequired(true);
        this.titleFeedback = new TextFeedbackPanel("titleFeedback", this.titleField);
        this.form.add(this.titleFeedback);

        this.maxFileSizeField = new TextField<>("maxFileSizeField", new PropertyModel<>(this, "maxFileSizeValue"));
        this.maxFileSizeField.setLabel(Model.of("Maximum File Size"));
        this.form.add(this.maxFileSizeField);
        this.maxFileSizeField.setRequired(true);
        this.maxFileSizeField.add(RangeValidator.range(1, 100));
        this.maxFileSizeFeedback = new TextFeedbackPanel("maxFileSizeFeedback", this.maxFileSizeField);
        this.form.add(this.maxFileSizeFeedback);

        this.maxFileQuantityField = new TextField<>("maxFileQuantityField", new PropertyModel<>(this, "maxFileQuantityValue"));
        this.maxFileQuantityField.setLabel(Model.of("Maximum File Quantity"));
        this.form.add(this.maxFileQuantityField);
        this.maxFileQuantityField.setRequired(true);
        this.maxFileQuantityField.add(RangeValidator.range(1, 10));
        this.maxFileQuantityFeedback = new TextFeedbackPanel("maxFileQuantityFeedback", this.maxFileQuantityField);
        this.form.add(this.maxFileQuantityFeedback);

        this.requestButton = new Button("requestButton");
        this.form.add(this.requestButton);
        this.requestButton.setOnSubmit(this::requestButtonSubmit);

        this.cancelButton = new BookmarkablePageLink<>("cancelButton", RequestPage.class);
        this.form.add(this.cancelButton);
    }

    private void requestButtonSubmit(Button button) {
        String requestId = Platform.uuid();
        JdbcNamed jdbcNamed = Platform.getBean(JdbcNamed.class);
        InsertQuery insertQuery = new InsertQuery("request");
        insertQuery.addValue("request_id = :request_id", requestId);
        insertQuery.addValue("title = :title", this.titleValue);
        insertQuery.addValue("created_on = :created_on", new Date());
        insertQuery.addValue("device_id = uuid()");
        insertQuery.addValue("uploaded_file = 0");
        insertQuery.addValue("maximum_file_quantity = :maximum_file_quantity", this.maxFileQuantityValue);
        insertQuery.addValue("maximum_file_size = :maximum_file_size", this.maxFileSizeValue);
        jdbcNamed.update(insertQuery.toSQL(), insertQuery.getParam());
        PageParameters parameters = new PageParameters();
        parameters.add("uuid", requestId);
        setResponsePage(UploadPage.class, parameters);
    }
}
