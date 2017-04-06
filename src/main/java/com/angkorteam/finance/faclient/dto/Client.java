package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public class Client implements Serializable {

    private Long id;

    private String accountNo;

    private Status status;

    private boolean active;

    private List<Integer> activationDate;

    private String firstname;

    private String lastname;

    private String displayName;

    private Long officeId;

    private String officeName;

    private Timeline timeline;

    private Long savingsProductId;

    private String savingsProductName;

    private List<Object> groups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Integer> getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(List<Integer> activationDate) {
        this.activationDate = activationDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Long getSavingsProductId() {
        return savingsProductId;
    }

    public void setSavingsProductId(Long savingsProductId) {
        this.savingsProductId = savingsProductId;
    }

    public String getSavingsProductName() {
        return savingsProductName;
    }

    public void setSavingsProductName(String savingsProductName) {
        this.savingsProductName = savingsProductName;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public static class Status implements Serializable {

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

    public static class Timeline implements Serializable {

        private List<Integer> submittedOnDate;

        private String submittedByUsername;

        private String submittedByFirstname;

        private String submittedByLastname;

        private List<Integer> activatedOnDate;

        private String activatedByUsername;

        private String activatedByFirstname;

        private String activatedByLastname;

    }

}
