package com.angkorteam.finance.faclient.dto.group;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class GroupResponse implements Serializable {

    private Long totalFilteredRecords;

    private List<Group> pageItems;

    public Long getTotalFilteredRecords() {
        return totalFilteredRecords;
    }

    public void setTotalFilteredRecords(Long totalFilteredRecords) {
        this.totalFilteredRecords = totalFilteredRecords;
    }

    public List<Group> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<Group> pageItems) {
        this.pageItems = pageItems;
    }
}
