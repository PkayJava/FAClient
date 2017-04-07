package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/7/17.
 */
public class ClientUndoWithdrawal implements Serializable {

    private String reopenedDate;

    private String locale;

    private String dateFormat;

    public String getReopenedDate() {
        return reopenedDate;
    }

    public void setReopenedDate(String reopenedDate) {
        this.reopenedDate = reopenedDate;
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
