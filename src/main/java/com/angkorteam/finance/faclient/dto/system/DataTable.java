package com.angkorteam.finance.faclient.dto.system;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class DataTable implements Serializable {

    private String applicationTableName;

    private String registeredTableName;

    private List<ColumnHeaderData> columnHeaderData;

    public String getApplicationTableName() {
        return applicationTableName;
    }

    public void setApplicationTableName(String applicationTableName) {
        this.applicationTableName = applicationTableName;
    }

    public String getRegisteredTableName() {
        return registeredTableName;
    }

    public void setRegisteredTableName(String registeredTableName) {
        this.registeredTableName = registeredTableName;
    }

    public List<ColumnHeaderData> getColumnHeaderData() {
        return columnHeaderData;
    }

    public void setColumnHeaderData(List<ColumnHeaderData> columnHeaderData) {
        this.columnHeaderData = columnHeaderData;
    }

    public static class ColumnHeaderData {

        private String columnName;

        private String columnType;

        private Integer columnLength;

        private String columnDisplayType;

        @SerializedName("isColumnNullable")
        private boolean columnNullable;

        @SerializedName("isColumnPrimaryKey")
        private boolean columnPrimaryKey;

        private List<ColumnValue> columnValues;

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnType() {
            return columnType;
        }

        public void setColumnType(String columnType) {
            this.columnType = columnType;
        }

        public Integer getColumnLength() {
            return columnLength;
        }

        public void setColumnLength(Integer columnLength) {
            this.columnLength = columnLength;
        }

        public String getColumnDisplayType() {
            return columnDisplayType;
        }

        public void setColumnDisplayType(String columnDisplayType) {
            this.columnDisplayType = columnDisplayType;
        }

        public boolean isColumnNullable() {
            return columnNullable;
        }

        public void setColumnNullable(boolean columnNullable) {
            this.columnNullable = columnNullable;
        }

        public boolean isColumnPrimaryKey() {
            return columnPrimaryKey;
        }

        public void setColumnPrimaryKey(boolean columnPrimaryKey) {
            this.columnPrimaryKey = columnPrimaryKey;
        }

        public List<ColumnValue> getColumnValues() {
            return columnValues;
        }

        public void setColumnValues(List<ColumnValue> columnValues) {
            this.columnValues = columnValues;
        }
    }

    public static class ColumnValue {

    }
}
