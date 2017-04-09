package com.angkorteam.finance.faclient.dto.common;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/9/17.
 */
public class Status implements Serializable {

    private Long id;

    private String code;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
