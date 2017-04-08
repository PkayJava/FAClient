package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class CodeValueUpdateResponse implements Serializable {

    private Integer resourceId;

    private CodeValueUpdate changes;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public CodeValueUpdate getChanges() {
        return changes;
    }

    public void setChanges(CodeValueUpdate changes) {
        this.changes = changes;
    }

}
