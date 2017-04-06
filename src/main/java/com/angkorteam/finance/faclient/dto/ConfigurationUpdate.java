package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class ConfigurationUpdate implements Serializable {

    private String name;

    private boolean enabled;

    private Long value;

    private boolean trapDoor;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTrapDoor() {
        return trapDoor;
    }

    public void setTrapDoor(boolean trapDoor) {
        this.trapDoor = trapDoor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

}
