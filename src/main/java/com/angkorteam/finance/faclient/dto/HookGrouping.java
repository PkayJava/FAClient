package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class HookGrouping implements Serializable {

    private String name;

    private List<HookEntity> entities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HookEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<HookEntity> entities) {
        this.entities = entities;
    }

}
