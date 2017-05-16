package com.prototype.sofa.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
public class Language extends NamedEntity {
    public Language() {
    }

    public Language(String name) {
        super(name);
    }
}
