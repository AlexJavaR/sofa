package com.prototype.sofa.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExistDepartment {
    private String nameLanguageDepartmentExist;
    private String nameCategoryDepartmentExist;
    private String nameDepartmentExist;
    private String nameLanguageDepartment;
    private String nameDepartment;

    public ExistDepartment(@JsonProperty("nameLanguageDepartmentExist") String nameLanguageDepartmentExist,
                           @JsonProperty("nameCategoryDepartmentExist") String nameCategoryDepartmentExist,
                           @JsonProperty("nameDepartmentExist") String nameDepartmentExist,
                           @JsonProperty("nameLanguageDepartment") String nameLanguageDepartment,
                           @JsonProperty("nameDepartment") String nameDepartment) {
        this.nameLanguageDepartmentExist = nameLanguageDepartmentExist;
        this.nameCategoryDepartmentExist = nameCategoryDepartmentExist;
        this.nameDepartmentExist = nameDepartmentExist;
        this.nameLanguageDepartment = nameLanguageDepartment;
        this.nameDepartment = nameDepartment;
    }

    public String getNameLanguageDepartmentExist() {
        return nameLanguageDepartmentExist;
    }

    public String getNameCategoryDepartmentExist() {
        return nameCategoryDepartmentExist;
    }

    public String getNameDepartmentExist() {
        return nameDepartmentExist;
    }

    public String getNameLanguageDepartment() {
        return nameLanguageDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }
}
