package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public class ClientReactivate implements Serializable {

    private String reactivationDate;

    private String locale;

    private String dateFormat;

    public String getReactivationDate() {
        return reactivationDate;
    }

    public void setReactivationDate(String reactivationDate) {
        this.reactivationDate = reactivationDate;
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
