package com.prototype.sofa.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToCategory {
    private String nameLanguage;
    private String nameCategory;
    private String nameExistLanguage;
    private String nameExistCategory;

    public ToCategory(@JsonProperty("nameLanguage") String nameLanguage, @JsonProperty("nameCategory") String nameCategory,
                      @JsonProperty("nameExistLanguage") String nameExistLanguage, @JsonProperty("nameExistCategory") String nameExistCategory) {
        this.nameLanguage = nameLanguage;
        this.nameCategory = nameCategory;
        this.nameExistLanguage = nameExistLanguage;
        this.nameExistCategory = nameExistCategory;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getNameExistLanguage() {
        return nameExistLanguage;
    }

    public String getNameExistCategory() {
        return nameExistCategory;
    }
}
