package com.angkorteam.finance.faclient.dto;

import com.angkorteam.finance.faclient.gson.AppType;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class Column implements Serializable {

    private String name;

    private AppType type;

    private String code;

    private boolean mandatory;

    private Integer length;

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppType getType() {
        return type;
    }

    public void setType(AppType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
