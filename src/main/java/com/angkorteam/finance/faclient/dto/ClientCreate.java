package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by socheatkhauv on 4/1/17.
 */
public class ClientCreate implements Serializable {

    private Long officeId;

    private String firstname;

    private String lastname;

    private String externalId;

    private String dateFormat;

    private String locale;

    private boolean active;

    private String activationDate;

    private String submittedOnDate;

    private Long savingsProductId;

    private List<DataTable> datatables;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getSubmittedOnDate() {
        return submittedOnDate;
    }

    public void setSubmittedOnDate(String submittedOnDate) {
        this.submittedOnDate = submittedOnDate;
    }

    public Long getSavingsProductId() {
        return savingsProductId;
    }

    public void setSavingsProductId(Long savingsProductId) {
        this.savingsProductId = savingsProductId;
    }

    public List<DataTable> getDatatables() {
        return datatables;
    }

    public void setDatatables(List<DataTable> datatables) {
        this.datatables = datatables;
    }

    public static class DataTable implements Serializable {

        private String registeredTableName;

        private Map<String, Object> data;

        public String getRegisteredTableName() {
            return registeredTableName;
        }

        public void setRegisteredTableName(String registeredTableName) {
            this.registeredTableName = registeredTableName;
        }

        public Map<String, Object> getData() {
            return data;
        }

        public void setData(Map<String, Object> data) {
            this.data = data;
        }
    }

}
