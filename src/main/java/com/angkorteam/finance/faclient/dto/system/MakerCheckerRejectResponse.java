package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class MakerCheckerRejectResponse implements Serializable {

    private Long commandId;

    public Long getCommandId() {
        return commandId;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

}
