package com.prototype.sofa.repository.departmentTranslate;

import com.prototype.sofa.model.Category;
import com.prototype.sofa.model.DepartmentTranslate;
import com.prototype.sofa.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentTranslateRepositoryImpl implements DepartmentTranslateRepository {

    @Autowired
    private CrudDepartmentTranslateRepository crudDepartmentTranslateRepository;

    @Override
    public DepartmentTranslate save(DepartmentTranslate departmentTranslate) {
        return crudDepartmentTranslateRepository.save(departmentTranslate);
    }

    @Override
    public boolean delete(int id) {
        return crudDepartmentTranslateRepository.delete(id) != 0;
    }

    @Override
    public DepartmentTranslate findOne(int id) {
        return crudDepartmentTranslateRepository.findOne(id);
    }

    @Override
    public List<DepartmentTranslate> findAll() {
        return crudDepartmentTranslateRepository.findAll();
    }

    @Override
    public List<DepartmentTranslate> getAllDepartmentByLanguage(Language language) {
        return crudDepartmentTranslateRepository.getAllDepartmentByLanguage(language);
    }

    @Override
    public List<DepartmentTranslate> getAllDepartmentByLanguageAndName(Language language, Category category) {
        return crudDepartmentTranslateRepository.getAllDepartmentByLanguageAndCategory(language, category);
    }

    @Override
    public DepartmentTranslate getDepartmentTranslateByCategoryAndNameIgnoreCase(Category category, String name) {
        return crudDepartmentTranslateRepository.getDepartmentTranslateByCategoryAndNameIgnoreCase(category, name);
    }

    @Override
    public DepartmentTranslate getDepartmentByLanguageAndCategoryAndName(Language language, Category category, String name) {
        return crudDepartmentTranslateRepository.getDepartmentTranslateByLanguageAndCategoryAndNameIgnoreCase(language, category, name);
    }
}
