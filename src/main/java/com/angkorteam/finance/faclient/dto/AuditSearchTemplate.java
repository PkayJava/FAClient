package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class AuditSearchTemplate implements Serializable {

    private List<AppUser> appUsers;

    private List<String> actionNames;

    private List<String> entityNames;

    private List<ProcessingResult> processingResults;

    public List<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }

    public List<String> getActionNames() {
        return actionNames;
    }

    public void setActionNames(List<String> actionNames) {
        this.actionNames = actionNames;
    }

    public List<String> getEntityNames() {
        return entityNames;
    }

    public void setEntityNames(List<String> entityNames) {
        this.entityNames = entityNames;
    }

    public List<ProcessingResult> getProcessingResults() {
        return processingResults;
    }

    public void setProcessingResults(List<ProcessingResult> processingResults) {
        this.processingResults = processingResults;
    }

    public static class AppUser implements Serializable {

        private Long id;

        private String username;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }

    public static class ProcessingResult implements Serializable {

        private Long id;

        private String processingResult;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getProcessingResult() {
            return processingResult;
        }

        public void setProcessingResult(String processingResult) {
            this.processingResult = processingResult;
        }
    }

}
