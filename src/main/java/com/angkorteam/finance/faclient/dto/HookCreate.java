package com.angkorteam.finance.faclient.dto;

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

    private List<HookEvent> events;

    private HookEvent config;

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

    public List<HookEvent> getEvents() {
        return events;
    }

    public void setEvents(List<HookEvent> events) {
        this.events = events;
    }

    public HookEvent getConfig() {
        return config;
    }

    public void setConfig(HookEvent config) {
        this.config = config;
    }
}
