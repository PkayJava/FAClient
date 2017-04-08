package com.angkorteam.finance.faclient.dto.client;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public class Client implements Serializable {

    private Long id;

    private String accountNo;

    private String externalId;

    private Status status;

    private SubStatus subStatus;

    private boolean active;

    private List<Integer> activationDate;

    private String firstname;

    private String lastname;

    private String displayName;

    private Gender gender;

    private ClientType clientType;

    private ClientClassification clientClassification;

    private Long officeId;

    private String officeName;

    private Timeline timeline;

    private ClientNonPersonDetail clientNonPersonDetails;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public SubStatus getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(SubStatus subStatus) {
        this.subStatus = subStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public ClientClassification getClientClassification() {
        return clientClassification;
    }

    public void setClientClassification(ClientClassification clientClassification) {
        this.clientClassification = clientClassification;
    }

    public ClientNonPersonDetail getClientNonPersonDetails() {
        return clientNonPersonDetails;
    }

    public void setClientNonPersonDetails(ClientNonPersonDetail clientNonPersonDetails) {
        this.clientNonPersonDetails = clientNonPersonDetails;
    }

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

        public List<Integer> getSubmittedOnDate() {
            return submittedOnDate;
        }

        public void setSubmittedOnDate(List<Integer> submittedOnDate) {
            this.submittedOnDate = submittedOnDate;
        }

        public String getSubmittedByUsername() {
            return submittedByUsername;
        }

        public void setSubmittedByUsername(String submittedByUsername) {
            this.submittedByUsername = submittedByUsername;
        }

        public String getSubmittedByFirstname() {
            return submittedByFirstname;
        }

        public void setSubmittedByFirstname(String submittedByFirstname) {
            this.submittedByFirstname = submittedByFirstname;
        }

        public String getSubmittedByLastname() {
            return submittedByLastname;
        }

        public void setSubmittedByLastname(String submittedByLastname) {
            this.submittedByLastname = submittedByLastname;
        }

        public List<Integer> getActivatedOnDate() {
            return activatedOnDate;
        }

        public void setActivatedOnDate(List<Integer> activatedOnDate) {
            this.activatedOnDate = activatedOnDate;
        }

        public String getActivatedByUsername() {
            return activatedByUsername;
        }

        public void setActivatedByUsername(String activatedByUsername) {
            this.activatedByUsername = activatedByUsername;
        }

        public String getActivatedByFirstname() {
            return activatedByFirstname;
        }

        public void setActivatedByFirstname(String activatedByFirstname) {
            this.activatedByFirstname = activatedByFirstname;
        }

        public String getActivatedByLastname() {
            return activatedByLastname;
        }

        public void setActivatedByLastname(String activatedByLastname) {
            this.activatedByLastname = activatedByLastname;
        }
    }

    public static class SubStatus implements Serializable {

        @SerializedName("isActive")
        private boolean active;

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }

    public static class Gender implements Serializable {

        @SerializedName("isActive")
        private boolean active;

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

    }

    public static class ClientType implements Serializable {

        @SerializedName("isActive")
        private boolean active;

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

    }

    public static class ClientClassification implements Serializable {

        @SerializedName("isActive")
        private boolean active;

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

    }

    public static class ClientNonPersonDetail implements Serializable {

        private Constitution constitution;

        private MainBusinessLine mainBusinessLine;

        public Constitution getConstitution() {
            return constitution;
        }

        public void setConstitution(Constitution constitution) {
            this.constitution = constitution;
        }

        public MainBusinessLine getMainBusinessLine() {
            return mainBusinessLine;
        }

        public void setMainBusinessLine(MainBusinessLine mainBusinessLine) {
            this.mainBusinessLine = mainBusinessLine;
        }
    }

    public static class Constitution implements Serializable {

        @SerializedName("isActive")
        private boolean active;

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

    }

    public static class MainBusinessLine implements Serializable {

        @SerializedName("isActive")
        private boolean active;

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

    }

}
