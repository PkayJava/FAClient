package com.angkorteam.finance.faclient.dto.group;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class GroupCreateResponse implements Serializable {

    private Long officeId;

    private Long groupId;

    private Long resourceId;

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
}
