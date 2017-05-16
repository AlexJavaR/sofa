package com.prototype.sofa.repository.departmentTranslate;

import com.prototype.sofa.model.Category;
import com.prototype.sofa.model.DepartmentTranslate;
import com.prototype.sofa.model.Language;

import java.util.List;

public interface DepartmentTranslateRepository {
    DepartmentTranslate save(DepartmentTranslate departmentTranslate);

    // false if not found
    boolean delete(int id);

    // null if not found
    DepartmentTranslate findOne(int id);

    List<DepartmentTranslate> findAll();

    DepartmentTranslate getDepartmentTranslateByCategoryAndNameIgnoreCase(Category category, String name);

    DepartmentTranslate getDepartmentByCategoryAndNameAndLanguage(Category category, String name, Language language);
}
