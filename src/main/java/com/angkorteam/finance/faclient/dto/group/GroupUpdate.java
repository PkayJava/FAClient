package com.angkorteam.finance.faclient.dto.group;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class GroupUpdate implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
