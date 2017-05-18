package com.prototype.sofa.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDepartment {
    private String nameDepartment;
    private String nameCategory;
    private String nameLanguage;

    public ToDepartment(@JsonProperty("nameDepartment") String nameDepartment,
                        @JsonProperty("nameCategory") String nameCategory,
                        @JsonProperty("nameLanguage") String nameLanguage) {
        this.nameDepartment = nameDepartment;
        this.nameCategory = nameCategory;
        this.nameLanguage = nameLanguage;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }
}
