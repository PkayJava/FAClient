package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class AccountNumberFormatTemplateResponse implements Serializable {

    private List<AccountType> accountTypeOptions;

    private Map<String, List<PrefixType>> prefixTypeOptions;

    public List<AccountType> getAccountTypeOptions() {
        return accountTypeOptions;
    }

    public void setAccountTypeOptions(List<AccountType> accountTypeOptions) {
        this.accountTypeOptions = accountTypeOptions;
    }

    public Map<String, List<PrefixType>> getPrefixTypeOptions() {
        return prefixTypeOptions;
    }

    public void setPrefixTypeOptions(Map<String, List<PrefixType>> prefixTypeOptions) {
        this.prefixTypeOptions = prefixTypeOptions;
    }
}
