package com.prototype.sofa.to;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToLanguage {
    private String nameLanguage;

    public ToLanguage(@JsonProperty("nameLanguage") String nameLanguage) {
        this.nameLanguage = nameLanguage;
    }

    public String getNameLanguage() {
        return nameLanguage;
    }
}
