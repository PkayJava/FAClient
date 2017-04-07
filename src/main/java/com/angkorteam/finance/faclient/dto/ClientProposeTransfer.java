package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;

/**
 * Created by socheatkhauv on 4/7/17.
 */
public class ClientProposeTransfer implements Serializable {

    private Long destinationOfficeId;

    private String note;

    public Long getDestinationOfficeId() {
        return destinationOfficeId;
    }

    public void setDestinationOfficeId(Long destinationOfficeId) {
        this.destinationOfficeId = destinationOfficeId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
