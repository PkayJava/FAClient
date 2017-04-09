package com.angkorteam.finance.server.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by socheatkhauv on 4/4/17.
 */
public class RequestRecord implements Serializable {

    private String requestId;

    private String title;

    private Date createdOn;

    private String deviceId;

    private Integer maximumFileQuantity;

    private Integer maximumFileSize;

    private Integer uploadedFile;

    private Date expiredNn;

    private Long version;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getMaximumFileQuantity() {
        return maximumFileQuantity;
    }

    public void setMaximumFileQuantity(Integer maximumFileQuantity) {
        this.maximumFileQuantity = maximumFileQuantity;
    }

    public Integer getMaximumFileSize() {
        return maximumFileSize;
    }

    public void setMaximumFileSize(Integer maximumFileSize) {
        this.maximumFileSize = maximumFileSize;
    }

    public Integer getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Integer uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public Date getExpiredNn() {
        return expiredNn;
    }

    public void setExpiredNn(Date expiredNn) {
        this.expiredNn = expiredNn;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
