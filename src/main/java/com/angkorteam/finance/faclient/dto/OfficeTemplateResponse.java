package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class OfficeTemplateResponse implements Serializable {

    private List<Integer> openingDate;

    private List<OfficeTemplateResponse> allowedParents;

    public List<Integer> getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(List<Integer> openingDate) {
        this.openingDate = openingDate;
    }

    public List<OfficeTemplateResponse> getAllowedParents() {
        return allowedParents;
    }

    public void setAllowedParents(List<OfficeTemplateResponse> allowedParents) {
        this.allowedParents = allowedParents;
    }
}
