package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class CodeUpdateResponse implements Serializable {

    private Long resourceId;

    private CodeUpdate changes;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public CodeUpdate getChanges() {
        return changes;
    }

    public void setChanges(CodeUpdate changes) {
        this.changes = changes;
    }
}
