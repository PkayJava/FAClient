package com.angkorteam.finance.faclient.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class HookCreateConfig implements Serializable {

    @SerializedName("Payload URL")
    private String payloadUrl;

    @SerializedName("Content Type")
    private String contentType;

    public String getPayloadUrl() {
        return payloadUrl;
    }

    public void setPayloadUrl(String payloadUrl) {
        this.payloadUrl = payloadUrl;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
