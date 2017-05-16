package com.prototype.sofa.model;

import javax.persistence.*;

@Entity
@Table(name = "key_words")
public class KeyWord extends NamedEntity {

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private RealWord realWord;

    @JoinColumn(name = "language_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Language language;

    public KeyWord() {
    }

    public KeyWord(String name, RealWord realWord, Language language) {
        super(name);
        this.realWord = realWord;
        this.language = language;
    }

    public RealWord getRealWord() {
        return realWord;
    }

    public void setRealWord(RealWord realWord) {
        this.realWord = realWord;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
