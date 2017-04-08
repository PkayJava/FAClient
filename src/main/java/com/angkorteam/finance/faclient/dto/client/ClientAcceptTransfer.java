package com.angkorteam.finance.faclient.dto.client;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/7/17.
 */
public class ClientAcceptTransfer implements Serializable {

    private Long destinationGroupId;

    private Long staffId;

    private String note;

    public Long getDestinationGroupId() {
        return destinationGroupId;
    }

    public void setDestinationGroupId(Long destinationGroupId) {
        this.destinationGroupId = destinationGroupId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
