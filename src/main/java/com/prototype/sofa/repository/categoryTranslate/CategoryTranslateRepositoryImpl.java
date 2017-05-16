package com.prototype.sofa.repository.categoryTranslate;

import com.prototype.sofa.model.CategoryTranslate;
import com.prototype.sofa.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryTranslateRepositoryImpl implements CategoryTranslateRepository {
    @Autowired
    private CrudCategoryTranslateRepository crudCategoryTranslateRepository;

    @Override
    public CategoryTranslate save(CategoryTranslate categoryTranslate) {
        return crudCategoryTranslateRepository.save(categoryTranslate);
    }

    @Override
    public boolean delete(int id) {
        return crudCategoryTranslateRepository.delete(id) != 0;
    }

    @Override
    public CategoryTranslate findOne(int id) {
        return crudCategoryTranslateRepository.findOne(id);
    }

    @Override
    public CategoryTranslate getByName(String name) {
        return crudCategoryTranslateRepository.getByNameIgnoreCase(name);
    }

    @Override
    public List<CategoryTranslate> findAll() {
        return crudCategoryTranslateRepository.findAll();
    }

    @Override
    public List<CategoryTranslate> getAllCategoriesByLanguage(Language language) {
        return crudCategoryTranslateRepository.getAllCategoriesByLanguage(language);
    }
}
