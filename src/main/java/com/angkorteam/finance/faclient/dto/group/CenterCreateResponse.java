package com.angkorteam.finance.faclient.dto.group;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class CenterCreateResponse implements Serializable {

    private Long commandId;

    private Long resourceId;

    private boolean rollbackTransaction;

    public Long getCommandId() {
        return commandId;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public boolean isRollbackTransaction() {
        return rollbackTransaction;
    }

    public void setRollbackTransaction(boolean rollbackTransaction) {
        this.rollbackTransaction = rollbackTransaction;
    }

}
