package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class CodeValueDeleteResponse implements Serializable {

    private Integer resourceId;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
    
}
