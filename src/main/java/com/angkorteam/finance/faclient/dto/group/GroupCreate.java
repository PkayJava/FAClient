package com.angkorteam.finance.faclient.dto.group;

import com.angkorteam.finance.faclient.dto.common.DataTable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 4/8/17.
 */
public class GroupCreate implements Serializable {

    private Long officeId;

    private String name;

    private boolean active;

    private String externalId;

    private List<String> clientMembers;

    private String dateFormat;

    private String locale;

    private String activationDate;

    private String submittedOnDate;

    private List<DataTable> datatables;

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
