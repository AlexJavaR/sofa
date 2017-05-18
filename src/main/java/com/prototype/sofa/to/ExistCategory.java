package com.prototype.sofa.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExistCategory {
    private String nameCategory;
    private String nameLanguageCategory;
    private String nameCategoryExist;
    private String nameLanguageCategoryExist;

    public ExistCategory(@JsonProperty("nameCategory") String nameCategory, @JsonProperty("nameLanguageCategory") String nameLanguageCategory,
                         @JsonProperty("nameCategoryExist") String nameCategoryExist, @JsonProperty("nameLanguageCategoryExist") String nameLanguageCategoryExist) {
        this.nameCategory = nameCategory;
        this.nameLanguageCategory = nameLanguageCategory;
        this.nameCategoryExist = nameCategoryExist;
        this.nameLanguageCategoryExist = nameLanguageCategoryExist;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getNameLanguageCategory() {
        return nameLanguageCategory;
    }

    public String getNameCategoryExist() {
        return nameCategoryExist;
    }

    public String getNameLanguageCategoryExist() {
        return nameLanguageCategoryExist;
    }
}
