package com.angkorteam.finance.faclient.dto.system;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class HookCreate implements Serializable {

    private String name;

    @SerializedName("isActive")
    private boolean active;

    private String displayName;

    private Long templateId;

    private List<Event> events;

    private Config config;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public static class Event implements Serializable {

        private String actionName;

        private String entityName;

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

    }

    public static class Config {

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
}
