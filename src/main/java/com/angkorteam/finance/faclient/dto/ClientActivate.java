package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public class ClientActivate implements Serializable {

    private String locale;

    private String dateFormat;

    private String activationDate;

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

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }
}
