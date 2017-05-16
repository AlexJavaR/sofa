package com.prototype.sofa.model;

import javax.persistence.*;

@Entity
@Table(name = "real_words")
public class RealWord extends NamedEntity {

    @JoinColumn(name = "language_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Language language;

    public RealWord() {
    }

    public RealWord(String name, Language language) {
        super(name);
        this.language = language;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
