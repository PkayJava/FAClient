package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public class ClientWithdraw implements Serializable {

    private String withdrawalDate;

    private Long withdrawalReasonId;

    private String locale;

    private String dateFormat;

    public String getWithdrawalDate() {
        return withdrawalDate;
    }

    public void setWithdrawalDate(String withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public Long getWithdrawalReasonId() {
        return withdrawalReasonId;
    }

    public void setWithdrawalReasonId(Long withdrawalReasonId) {
        this.withdrawalReasonId = withdrawalReasonId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
