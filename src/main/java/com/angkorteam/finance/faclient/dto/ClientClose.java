package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public class ClientClose implements Serializable {

    private String dateFormat;

    private String locale;

    private String closureDate;

    private Long closureReasonId;

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getClosureDate() {
        return closureDate;
    }

    public void setClosureDate(String closureDate) {
        this.closureDate = closureDate;
    }

    public Long getClosureReasonId() {
        return closureReasonId;
    }

    public void setClosureReasonId(Long closureReasonId) {
        this.closureReasonId = closureReasonId;
    }
}
