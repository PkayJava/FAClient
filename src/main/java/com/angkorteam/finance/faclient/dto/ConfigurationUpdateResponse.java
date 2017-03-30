package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class ConfigurationUpdateResponse implements Serializable {

    private Long resourceId;

    private ConfigurationUpdate changes;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public ConfigurationUpdate getChanges() {
        return changes;
    }

    public void setChanges(ConfigurationUpdate changes) {
        this.changes = changes;
    }
}
