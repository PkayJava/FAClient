package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class OfficeUpdateResponse implements Serializable {

    private Long officeId;

    private Long resourceId;

    private OfficeUpdate changes;

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public OfficeUpdate getChanges() {
        return changes;
    }

    public void setChanges(OfficeUpdate changes) {
        this.changes = changes;
    }
}
