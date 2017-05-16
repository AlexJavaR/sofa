package com.prototype.sofa.repository.categoryTranslate;

import com.prototype.sofa.model.CategoryTranslate;
import com.prototype.sofa.model.Language;

import java.util.List;

public interface CategoryTranslateRepository {
    CategoryTranslate save(CategoryTranslate categoryTranslate);

    // false if not found
    boolean delete(int id);

    // null if not found
    CategoryTranslate findOne(int id);

    // null if not found
    CategoryTranslate getByName(String name);

    List<CategoryTranslate> findAll();

    List<CategoryTranslate> getAllCategoriesByLanguage(Language language);
}
