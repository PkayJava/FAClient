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

    public static class AccountType implements Serializable {

        private Long id;

        private String code;

        private String value;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public static class PrefixType implements Serializable {

        private Long id;

        private String code;

        private String value;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
