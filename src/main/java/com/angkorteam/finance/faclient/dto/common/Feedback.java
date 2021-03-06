package com.angkorteam.finance.faclient.dto.common;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class Feedback implements Serializable {

    @Expose
    private String developerMessage;

    @Expose
    private String httpStatusCode;

    @Expose
    private String defaultUserMessage;

    @Expose
    private String userMessageGlobalisationCode;

    @Expose
    private List<Error> errors;

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getDefaultUserMessage() {
        return defaultUserMessage;
    }

    public void setDefaultUserMessage(String defaultUserMessage) {
        this.defaultUserMessage = defaultUserMessage;
    }

    public String getUserMessageGlobalisationCode() {
        return userMessageGlobalisationCode;
    }

    public void setUserMessageGlobalisationCode(String userMessageGlobalisationCode) {
        this.userMessageGlobalisationCode = userMessageGlobalisationCode;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public static class Error implements Serializable {

        @Expose
        private String developerMessage;

        @Expose
        private String defaultUserMessage;

        @Expose
        private String userMessageGlobalisationCode;

        @Expose
        private String parameterName;

        @Expose
        private String value;

        @Expose
        private List<Map<String, Object>> args;

        public String getDeveloperMessage() {
            return developerMessage;
        }

        public void setDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
        }

        public String getDefaultUserMessage() {
            return defaultUserMessage;
        }

        public void setDefaultUserMessage(String defaultUserMessage) {
            this.defaultUserMessage = defaultUserMessage;
        }

        public String getUserMessageGlobalisationCode() {
            return userMessageGlobalisationCode;
        }

        public void setUserMessageGlobalisationCode(String userMessageGlobalisationCode) {
            this.userMessageGlobalisationCode = userMessageGlobalisationCode;
        }

        public String getParameterName() {
            return parameterName;
        }

        public void setParameterName(String parameterName) {
            this.parameterName = parameterName;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<Map<String, Object>> getArgs() {
            return args;
        }

        public void setArgs(List<Map<String, Object>> args) {
            this.args = args;
        }
    }

}
