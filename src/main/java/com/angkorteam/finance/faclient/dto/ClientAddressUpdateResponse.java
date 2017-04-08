package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/7/17.
 */
public class ClientAddressUpdateResponse implements Serializable {

    private Long resourceId;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

}
