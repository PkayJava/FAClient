package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class HookUpdateResponse implements Serializable {

    private Long resourceId;

    private HookUpdate changes;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public HookUpdate getChanges() {
        return changes;
    }

    public void setChanges(HookUpdate changes) {
        this.changes = changes;
    }

}
