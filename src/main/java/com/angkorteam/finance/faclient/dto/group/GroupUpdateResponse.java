package com.angkorteam.finance.faclient.dto.group;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class GroupUpdateResponse implements Serializable {

    private Long officeId;

    private Long groupId;

    private Long resourceId;

    private GroupUpdate changes;

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public GroupUpdate getChanges() {
        return changes;
    }

    public void setChanges(GroupUpdate changes) {
        this.changes = changes;
    }
}
