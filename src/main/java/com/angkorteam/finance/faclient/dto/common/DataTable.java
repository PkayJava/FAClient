package com.angkorteam.finance.faclient.dto.common;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class DataTable implements Serializable {

    private String registeredTableName;

    private Map<String, Object> data;

    public String getRegisteredTableName() {
        return registeredTableName;
    }

    public void setRegisteredTableName(String registeredTableName) {
        this.registeredTableName = registeredTableName;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
