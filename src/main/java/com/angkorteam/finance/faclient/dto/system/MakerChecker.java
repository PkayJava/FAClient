package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class MakerChecker implements Serializable {

    private Long id;

    private String actionName;

    private String entityName;

    private Long resourceId;

    private String maker;

    private Long madeOnDate;

    private String processingResult;

    private String officeName;

    private String clientName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public Long getMadeOnDate() {
        return madeOnDate;
    }

    public void setMadeOnDate(Long madeOnDate) {
        this.madeOnDate = madeOnDate;
    }

    public String getProcessingResult() {
        return processingResult;
    }

    public void setProcessingResult(String processingResult) {
        this.processingResult = processingResult;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
