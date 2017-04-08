package com.angkorteam.finance.faclient.dto.client;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class FieldConfiguration implements Serializable {

    private Long fieldConfigurationId;

    private String entity;

    private String subentity;

    private String field;

    @SerializedName("is_enabled")
    private boolean enabled;

    @SerializedName("is_mandatory")
    private boolean mandatory;

    @SerializedName("validation_regex")
    private String validationRegex;

    public Long getFieldConfigurationId() {
        return fieldConfigurationId;
    }

    public void setFieldConfigurationId(Long fieldConfigurationId) {
        this.fieldConfigurationId = fieldConfigurationId;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getSubentity() {
        return subentity;
    }

    public void setSubentity(String subentity) {
        this.subentity = subentity;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getValidationRegex() {
        return validationRegex;
    }

    public void setValidationRegex(String validationRegex) {
        this.validationRegex = validationRegex;
    }
}
