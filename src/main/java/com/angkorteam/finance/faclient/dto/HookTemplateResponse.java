package com.angkorteam.finance.faclient.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/30/17.
 */
public class HookTemplateResponse implements Serializable {

    private List<HookTemplate> templates;

    private List<HookGrouping> groupings;

    public List<HookTemplate> getTemplates() {
        return templates;
    }

    public void setTemplates(List<HookTemplate> templates) {
        this.templates = templates;
    }

    public List<HookGrouping> getGroupings() {
        return groupings;
    }

    public void setGroupings(List<HookGrouping> groupings) {
        this.groupings = groupings;
    }

}
