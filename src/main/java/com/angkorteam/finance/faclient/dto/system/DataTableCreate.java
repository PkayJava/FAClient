package com.angkorteam.finance.faclient.dto.system;

import com.angkorteam.finance.faclient.gson.AppTable;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class DataTableCreate implements Serializable {


    @SerializedName("apptableName")
    private AppTable applicationTableName;

    @SerializedName("datatableName")
    private String registeredTableName;

    private List<Column> columns;

    public AppTable getApplicationTableName() {
        return applicationTableName;
    }

    public void setApplicationTableName(AppTable applicationTableName) {
        this.applicationTableName = applicationTableName;
    }

    public String getRegisteredTableName() {
        return registeredTableName;
    }

    public void setRegisteredTableName(String registeredTableName) {
        this.registeredTableName = registeredTableName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

}
