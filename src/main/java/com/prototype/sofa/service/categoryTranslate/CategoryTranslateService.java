package com.prototype.sofa.service.categoryTranslate;

import com.prototype.sofa.model.CategoryTranslate;
import com.prototype.sofa.to.ExistCategory;
import com.prototype.sofa.util.exception.NotFoundException;

import java.util.List;
import java.util.Map;

public interface CategoryTranslateService {
    CategoryTranslate save(CategoryTranslate categoryTranslate);

    CategoryTranslate findOne(int id) throws NotFoundException;

    CategoryTranslate getByName(String name) throws NotFoundException;

    List<CategoryTranslate> findAll();

    CategoryTranslate addCategoryToExist(ExistCategory existCategory);

    List<CategoryTranslate> findAllCategoriesByLanguage(String nameLanguage);

    List<CategoryTranslate> createCategoryWithFewLanguages(Map<String, String> categories);

    List<CategoryTranslate> getCategoryWithAllLanguagesByName(String nameCategory);

    List<CategoryTranslate> getCategoryWithAllLanguagesById(Integer id);
}
