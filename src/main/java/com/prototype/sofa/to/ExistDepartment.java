package com.prototype.sofa.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExistDepartment {
    private String nameDepartment;
    private String nameLanguageDepartment;
    private String nameDepartmentExist;
    private String nameLanguageDepartmentExist;
    private String nameCategoryDepartmentExist;

    public ExistDepartment(@JsonProperty("nameDepartment") String nameDepartment, @JsonProperty("nameLanguageDepartment") String nameLanguageDepartment,
                           @JsonProperty("nameDepartmentExist") String nameDepartmentExist, @JsonProperty("nameLanguageDepartmentExist") String nameLanguageDepartmentExist,
                           @JsonProperty("nameCategoryDepartmentExist") String nameCategoryDepartmentExist) {
        this.nameDepartment = nameDepartment;
        this.nameLanguageDepartment = nameLanguageDepartment;
        this.nameDepartmentExist = nameDepartmentExist;
        this.nameLanguageDepartmentExist = nameLanguageDepartmentExist;
        this.nameCategoryDepartmentExist = nameCategoryDepartmentExist;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public String getNameLanguageDepartment() {
        return nameLanguageDepartment;
    }

    public String getNameDepartmentExist() {
        return nameDepartmentExist;
    }

    public String getNameLanguageDepartmentExist() {
        return nameLanguageDepartmentExist;
    }

    public String getNameCategoryDepartmentExist() {
        return nameCategoryDepartmentExist;
    }
}
