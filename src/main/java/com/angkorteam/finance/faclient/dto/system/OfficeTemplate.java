package com.angkorteam.finance.faclient.dto.system;

import java.io.Serializable;
import java.util.List;

/**
 * Created by socheatkhauv on 3/29/17.
 */
public class OfficeTemplate implements Serializable {

    private List<Integer> openingDate;

    private List<AllowedParent> allowedParents;

    public List<Integer> getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(List<Integer> openingDate) {
        this.openingDate = openingDate;
    }

    public List<AllowedParent> getAllowedParents() {
        return allowedParents;
    }

    public void setAllowedParents(List<AllowedParent> allowedParents) {
        this.allowedParents = allowedParents;
    }

    public static class AllowedParent {
        private Long id;

        private String name;

        private String nameDecorated;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNameDecorated() {
            return nameDecorated;
        }

        public void setNameDecorated(String nameDecorated) {
            this.nameDecorated = nameDecorated;
        }
    }
}
