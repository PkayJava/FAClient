package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public class ClientReject implements Serializable {

    private String rejectionDate;

    private Long rejectionReasonId;

    private String locale;

    private String dateFormat;

    public String getRejectionDate() {
        return rejectionDate;
    }

    public void setRejectionDate(String rejectionDate) {
        this.rejectionDate = rejectionDate;
    }

    public Long getRejectionReasonId() {
        return rejectionReasonId;
    }

    public void setRejectionReasonId(Long rejectionReasonId) {
        this.rejectionReasonId = rejectionReasonId;
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
