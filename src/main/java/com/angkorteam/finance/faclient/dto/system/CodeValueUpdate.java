package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class CodeValueUpdate implements Serializable {

    private String name;

    private String description;

    private int position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
