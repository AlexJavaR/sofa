package com.prototype.sofa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @JsonBackReference
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "category")
    private List<CategoryTranslate> categoryTranslate;

    public Category() {
    }

    public List<CategoryTranslate> getCategoryTranslate() {
        return categoryTranslate;
    }

    public void setCategoryTranslate(List<CategoryTranslate> categoryTranslate) {
        this.categoryTranslate = categoryTranslate;
    }
}
