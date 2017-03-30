package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class HookTemplate implements Serializable {

    private String name;

    private List<HookSchema> schema;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HookSchema> getSchema() {
        return schema;
    }

    public void setSchema(List<HookSchema> schema) {
        this.schema = schema;
    }
}
