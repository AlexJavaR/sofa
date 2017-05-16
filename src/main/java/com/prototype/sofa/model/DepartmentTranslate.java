package com.prototype.sofa.model;

import javax.persistence.*;

@Entity
@Table(name = "departments_translate")
public class DepartmentTranslate extends NamedEntity {

    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @JoinColumn(name = "language_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Language language;

    @JoinColumn(name = "department_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    public DepartmentTranslate() {
    }

    public DepartmentTranslate(String name, Category category, Language language, Department department) {
        super(name);
        this.category = category;
        this.language = language;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
