package com.angkorteam.finance.faclient.dto.client;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public class ClientUpdateResponse implements Serializable {

    private Long officeId;

    private Long clientId;

    private Long resourceId;

    private ClientUpdate changes;

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

    public ClientUpdate getChanges() {
        return changes;
    }

    public void setChanges(ClientUpdate changes) {
        this.changes = changes;
    }
}
