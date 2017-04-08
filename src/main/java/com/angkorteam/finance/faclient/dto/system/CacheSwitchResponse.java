package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class CacheSwitchResponse implements Serializable {

    private CacheSwitch changes;

    public CacheSwitch getChanges() {
        return changes;
    }

    public void setChanges(CacheSwitch changes) {
        this.changes = changes;
    }
}
