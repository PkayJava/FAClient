package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class AccountNumberFormatUpdate implements Serializable {

    private Long prefixType;

    public Long getPrefixType() {
        return prefixType;
    }

    public void setPrefixType(Long prefixType) {
        this.prefixType = prefixType;
    }
}
