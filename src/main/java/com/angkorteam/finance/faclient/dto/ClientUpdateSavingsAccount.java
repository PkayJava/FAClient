package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/7/17.
 */
public class ClientUpdateSavingsAccount implements Serializable {

    private Long savingsAccountId;

    public Long getSavingsAccountId() {
        return savingsAccountId;
    }

    public void setSavingsAccountId(Long savingsAccountId) {
        this.savingsAccountId = savingsAccountId;
    }

}
