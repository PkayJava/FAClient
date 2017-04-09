package com.angkorteam.finance.server.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by socheatkhauv on 4/4/17.
 */
public class FileRecord implements Serializable {

    private String fileId;

    private String requestId;

    private Date createdOn;

    private Long size;

    private String path;

    private String serverFilename;

    private String clientFilename;

    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getServerFilename() {
        return serverFilename;
    }

    public void setServerFilename(String serverFilename) {
        this.serverFilename = serverFilename;
    }

    public String getClientFilename() {
        return clientFilename;
    }

    public void setClientFilename(String clientFilename) {
        this.clientFilename = clientFilename;
    }
}
