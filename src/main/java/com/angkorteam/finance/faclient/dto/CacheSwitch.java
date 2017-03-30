package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class CacheSwitch implements Serializable {

    private Long cacheType;

    public Long getCacheType() {
        return cacheType;
    }

    public void setCacheType(Long cacheType) {
        this.cacheType = cacheType;
    }
}
