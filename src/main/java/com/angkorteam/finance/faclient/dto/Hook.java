package com.angkorteam.finance.faclient.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class Hook implements Serializable {

    private Long id;

    private String name;

    @SerializedName("isActive")
    private boolean active;

    private String displayName;

    private Long templateId;

    private String templateName;

    private List<Integer> createdAt;

    private List<Integer> updatedAt;

    private List<HookEvent> events;

    private List<HookConfig> config;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<HookConfig> getConfig() {
        return config;
    }

    public void setConfig(List<HookConfig> config) {
        this.config = config;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public List<Integer> getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(List<Integer> createdAt) {
        this.createdAt = createdAt;
    }

    public List<Integer> getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(List<Integer> updatedAt) {
        this.updatedAt = updatedAt;
    }
}
