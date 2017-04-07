package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/7/17.
 */
public class ClientUnAssignStaffResponse implements Serializable {

    private Long officeId;

    private Long clientId;

    private Long resourceId;

    private ClientUnAssignStaff changes;

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public ClientUnAssignStaff getChanges() {
        return changes;
    }

    public void setChanges(ClientUnAssignStaff changes) {
        this.changes = changes;
    }
}
