package com.angkorteam.finance.faclient.dto.client;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 4/6/17.
 */
public class ClientListResponse implements Serializable {

    private Long totalFilteredRecords;

    private List<Client> pageItems;

    public Long getTotalFilteredRecords() {
        return totalFilteredRecords;
    }

    public void setTotalFilteredRecords(Long totalFilteredRecords) {
        this.totalFilteredRecords = totalFilteredRecords;
    }

    public List<Client> getPageItems() {
        return pageItems;
    }

    public void setPageItems(List<Client> pageItems) {
        this.pageItems = pageItems;
    }
}
