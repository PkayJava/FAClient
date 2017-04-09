package com.angkorteam.finance.faclient.dto.system;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class Role implements Serializable {

    @Expose
    private Long id;

    @Expose
    private String name;

    @Expose
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
