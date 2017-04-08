package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class AuditPaginationResponse implements Serializable {

    private Long totalFilteredRecords;

    private List<Audit> pageItems;

    public Long getTotalFilteredRecords() {
        return totalFilteredRecords;
    }

    public void setTotalFilteredRecords(Long totalFilteredRecords) {
        this.totalFilteredRecords = totalFilteredRecords;
    }

    public List<Audit> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<Audit> pageItems) {
        this.pageItems = pageItems;
    }
}
