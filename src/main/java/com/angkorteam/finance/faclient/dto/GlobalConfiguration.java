package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class GlobalConfiguration implements Serializable {

    private List<Configuration> globalConfiguration;

    public List<Configuration> getGlobalConfiguration() {
        return globalConfiguration;
    }

    public void setGlobalConfiguration(List<Configuration> globalConfiguration) {
        this.globalConfiguration = globalConfiguration;
    }
    
}
