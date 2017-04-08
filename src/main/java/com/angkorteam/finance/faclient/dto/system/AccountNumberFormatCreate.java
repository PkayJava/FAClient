package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class AccountNumberFormatCreate implements Serializable {

    private Long accountType;

    private Long prefixType;

    public Long getAccountType() {
        return accountType;
    }

    public void setAccountType(Long accountType) {
        this.accountType = accountType;
    }

    public Long getPrefixType() {
        return prefixType;
    }

    public void setPrefixType(Long prefixType) {
        this.prefixType = prefixType;
    }
}
