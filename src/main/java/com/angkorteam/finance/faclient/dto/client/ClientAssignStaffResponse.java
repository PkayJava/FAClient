package com.angkorteam.finance.faclient.dto.client;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/7/17.
 */
public class ClientAssignStaffResponse implements Serializable {

    private Long officeId;

    private Long clientId;

    private Long resourceId;

    private ClientAssignStaff changes;

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

    public ClientAssignStaff getChanges() {
        return changes;
    }

    public void setChanges(ClientAssignStaff changes) {
        this.changes = changes;
    }
}
