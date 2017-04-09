package com.angkorteam.finance.server.validator;

import com.angkorteam.framework.spring.JdbcTemplate;
import com.angkorteam.finance.server.Platform;
import com.angkorteam.finance.server.model.RequestRecord;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.util.lang.Bytes;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

import java.util.List;

/**
 * Created by socheatkhauv on 4/3/17.
 */
public class UploadFileValidator implements IValidator<List<FileUpload>> {

    private final String uuid;

    public UploadFileValidator(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void validate(IValidatable<List<FileUpload>> validatable) {
        List<FileUpload> fileUploads = validatable.getValue();
        if (fileUploads != null && !fileUploads.isEmpty()) {
            JdbcTemplate jdbcTemplate = Platform.getBean(JdbcTemplate.class);
            RequestRecord requestRecord = jdbcTemplate.queryForObject("select * from request where request_id = ?", RequestRecord.class, this.uuid);
            Integer maximumFileQuantity = requestRecord.getMaximumFileQuantity();
            Integer uploadedFile = requestRecord.getUploadedFile();
            if (uploadedFile >= maximumFileQuantity) {
                validatable.error(new ValidationError(this, "quantity"));
            } else {
                FileUpload fileUpload = fileUploads.get(0);
                Integer maximumFileSize = requestRecord.getMaximumFileSize();
                long bytes = Bytes.megabytes(maximumFileSize).bytes();
                if (fileUpload.getSize() > bytes) {
                    validatable.error(new ValidationError(this, "size"));
                }
            }
        }
    }

}
