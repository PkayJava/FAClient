package com.angkorteam.finance.faclient.dto.group;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class CenterListResponse implements Serializable {

    private Long totalFilteredRecords;

    private List<Center> pageItems;

    public Long getTotalFilteredRecords() {
        return totalFilteredRecords;
    }

    public void setTotalFilteredRecords(Long totalFilteredRecords) {
        this.totalFilteredRecords = totalFilteredRecords;
    }

    public List<Center> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<Center> pageItems) {
        this.pageItems = pageItems;
    }
}
