package com.angkorteam.finance.faclient.dto.system;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class DataTableGenericResultSetResponse implements Serializable {


    private List<ColumnHeader> columnHeaders;

    private List<Record> data;

    public List<ColumnHeader> getColumnHeaders() {
        return columnHeaders;
    }

    public void setColumnHeaders(List<ColumnHeader> columnHeaders) {
        this.columnHeaders = columnHeaders;
    }

    public List<Record> getData() {
        return data;
    }

    public void setData(List<Record> data) {
        this.data = data;
    }

    public static class ColumnHeader implements Serializable {

        private String columnName;

        private String columnType;

        private Integer columnLength;

        private String columnDisplayType;

        @SerializedName("isColumnNullable")
        private boolean columnNullable;

        @SerializedName("isColumnPrimaryKey")
        private boolean columnPrimaryKey;

        private List<ColumnValue> columnValues;

        private String columnCode;

        public String getColumnCode() {
            return columnCode;
        }

        public void setColumnCode(String columnCode) {
            this.columnCode = columnCode;
        }

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

    public static class ColumnValue implements Serializable {

        private Long id;

        private String value;

        private Long score;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Long getScore() {
            return score;
        }

        public void setScore(Long score) {
            this.score = score;
        }
    }

    public static class Record implements Serializable {

        private List<Object> row;

        public List<Object> getRow() {
            return row;
        }

        public void setRow(List<Object> row) {
            this.row = row;
        }

    }
}
