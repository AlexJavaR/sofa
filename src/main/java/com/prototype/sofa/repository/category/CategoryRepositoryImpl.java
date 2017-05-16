package com.prototype.sofa.repository.category;

import com.prototype.sofa.model.Category;
import com.prototype.sofa.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private CrudCategoryRepository crudCategoryRepository;

    @Override
    public Category save(Category category) {
        return crudCategoryRepository.save(category);
    }

    @Override
    public boolean delete(int id) {
        return crudCategoryRepository.delete(id) != 0;
    }

    @Override
    public Category findOne(int id) {
        return crudCategoryRepository.findOne(id);
    }

//    @Override
//    public Category getByName(String name) {
//        return crudCategoryRepository.getByNameIgnoreCase(name);
//    }

    @Override
    public List<Category> findAll() {
        return crudCategoryRepository.findAll();
    }

//    @Override
//    public List<Category> getAllCategoriesByLanguage(Language language) {
//        return crudCategoryRepository.getAllCategoriesByLanguage(language);
//    }

}
