package com.angkorteam.finance.faclient.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class HookUpdate implements Serializable {

    private String name;

    @SerializedName("isActive")
    private boolean active;

    private String displayName;

    private List<HookEvent> events;

    private HookCreateConfig config;

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

    public List<HookEvent> getEvents() {
        return events;
    }

    public void setEvents(List<HookEvent> events) {
        this.events = events;
    }

    public HookCreateConfig getConfig() {
        return config;
    }

    public void setConfig(HookCreateConfig config) {
        this.config = config;
    }
}
