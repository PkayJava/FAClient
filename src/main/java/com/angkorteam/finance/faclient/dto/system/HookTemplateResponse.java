package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class HookTemplateResponse implements Serializable {

    private List<HookTemplate> templates;

    private List<HookGrouping> groupings;

    public List<HookTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(List<HookTemplate> templates) {
        this.templates = templates;
    }

    public List<HookGrouping> getGroupings() {
        return groupings;
    }

    public void setGroupings(List<HookGrouping> groupings) {
        this.groupings = groupings;
    }

    public static class HookGrouping implements Serializable {

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

    public static class HookEntity implements Serializable {

        private String name;

        private List<String> actions;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getActions() {
            return actions;
        }

        public void setActions(List<String> actions) {
            this.actions = actions;
        }
    }

    public static class HookSchema implements Serializable {

        private String fieldName;

        private String fieldType;

        private boolean optional;

        private String placeholder;

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getFieldType() {
            return fieldType;
        }

        public void setFieldType(String fieldType) {
            this.fieldType = fieldType;
        }

        public boolean isOptional() {
            return optional;
        }

        public void setOptional(boolean optional) {
            this.optional = optional;
        }

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }
    }

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


}
