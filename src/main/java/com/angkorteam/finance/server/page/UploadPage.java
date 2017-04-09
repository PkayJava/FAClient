package com.angkorteam.finance.server.page;

import com.angkorteam.framework.jdbc.SelectQuery;
import com.angkorteam.framework.jdbc.UpdateQuery;
import com.angkorteam.framework.spring.JdbcNamed;
import com.angkorteam.framework.spring.JdbcTemplate;
import com.angkorteam.framework.wicket.AdminLTEPage;
import com.angkorteam.framework.wicket.markup.html.form.Button;
import com.angkorteam.framework.wicket.markup.html.form.Form;
import com.angkorteam.framework.wicket.markup.html.panel.TextFeedbackPanel;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.model.RequestRecord;
import com.angkorteam.finance.server.validator.UploadFileValidator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * Created by socheatkhauv on 4/2/17.
 */
public class UploadPage extends AdminLTEPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadPage.class);

    private Form<Void> form;

    private String titleValue;
    private Label titleLabel;

    private Integer maxFileSizeValue;
    private Label maxFileSizeLabel;

    private List<FileUpload> fileValue;
    private FileUploadField fileField;
    private TextFeedbackPanel fileFeedback;

    private BookmarkablePageLink<Void> cancelButton;
    private Button uploadButton;

    private String uuid = null;
    private Long version;

    @Override
    protected void onInitialize() {
        super.onInitialize();

        PageParameters parameters = getPageParameters();

        this.uuid = parameters.get("uuid").toOptionalString();

        JdbcTemplate jdbcTemplate = Platform.getBean(JdbcTemplate.class);

        RequestRecord requestRecord = jdbcTemplate.queryForObject("select * from request where request_id = ?", RequestRecord.class, this.uuid);
        this.version = requestRecord.getVersion();

        this.form = new Form<>("form");
        add(this.form);
        this.form.setMultiPart(true);

        this.titleValue = requestRecord.getTitle();
        this.titleLabel = new Label("titleLabel", new PropertyModel<>(this, "titleValue"));
        this.form.add(this.titleLabel);

        this.maxFileSizeValue = requestRecord.getMaximumFileSize();
        this.maxFileSizeLabel = new Label("maxFileSizeLabel", new PropertyModel<>(this, "maxFileSizeValue"));
        this.form.add(this.maxFileSizeLabel);

        this.fileField = new FileUploadField("fileField", new PropertyModel<>(this, "fileValue"));
        this.form.add(this.fileField);
        this.fileField.setLabel(Model.of("File"));
        this.fileField.setRequired(true);
        this.fileField.add(new UploadFileValidator(this.uuid));
        this.fileFeedback = new TextFeedbackPanel("fileFeedback", this.fileField);
        this.form.add(this.fileFeedback);

        this.cancelButton = new BookmarkablePageLink<>("cancelButton", UploadPage.class, getPageParameters());
        this.form.add(this.cancelButton);

        this.uploadButton = new Button("uploadButton");
        this.form.add(this.uploadButton);
        this.uploadButton.setOnSubmit(this::uploadButtonSubmit);

        if (requestRecord.getUploadedFile().equals(requestRecord.getMaximumFileQuantity())) {
            setResponsePage(RequestPage.class);
        }
    }

    private void uploadButtonSubmit(Button button) {
        FileUpload fileUpload = this.fileValue.get(0);
        File temp = new File(FileUtils.getTempDirectory(), System.currentTimeMillis() + "_" + RandomStringUtils.randomAlphanumeric(10) + "." + FilenameUtils.getExtension(fileUpload.getClientFileName()));
        try {
            fileUpload.writeTo(temp);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            setResponsePage(UploadPage.class, getPageParameters());
            return;
        }
        Platform.saveFile(this.uuid, temp, fileUpload.getClientFileName());
        FileUtils.deleteQuietly(temp);
        DateTime now = new DateTime();
        JdbcNamed jdbcNamed = Platform.getBean(JdbcNamed.class);
        SelectQuery selectQuery = new SelectQuery("request", true);
        selectQuery.addField("request_id");
        selectQuery.addWhere("request_id = :request_id", this.uuid);
        jdbcNamed.queryForMap(selectQuery.toSQL(), selectQuery.getParam());
        UpdateQuery updateQuery = new UpdateQuery("request");
        updateQuery.addValue("expired_on = :expired_on", now.plusDays(7).toDate());
        updateQuery.addValue("version = :version", this.version);
        updateQuery.addValue("uploaded_file = uploaded_file + 1");
        updateQuery.addWhere("request_id = :request_id", this.uuid);
        jdbcNamed.update(updateQuery.toSQL(), updateQuery.getParam());
        setResponsePage(UploadPage.class, getPageParameters());
    }

}
