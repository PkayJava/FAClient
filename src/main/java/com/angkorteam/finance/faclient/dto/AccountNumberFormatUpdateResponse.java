package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class AccountNumberFormatUpdateResponse implements Serializable {

    private Long resourceId;

    private AccountNumberFormatUpdate changes;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public AccountNumberFormatUpdate getChanges() {
        return changes;
    }

    public void setChanges(AccountNumberFormatUpdate changes) {
        this.changes = changes;
    }

    public static class AccountNumberFormatUpdate {
        private String prefixType;

        public String getPrefixType() {
            return prefixType;
        }

        public void setPrefixType(String prefixType) {
            this.prefixType = prefixType;
        }
    }
}
