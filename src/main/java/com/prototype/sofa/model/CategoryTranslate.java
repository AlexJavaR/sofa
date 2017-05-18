package com.prototype.sofa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "categories_translate")
public class CategoryTranslate extends NamedEntity {
    @JsonManagedReference
    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @JoinColumn(name = "language_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Language language;

    public CategoryTranslate() {
    }

    public CategoryTranslate(String name, Category category, Language language) {
        super(name);
        this.category = category;
        this.language = language;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
