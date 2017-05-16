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
    public DepartmentTranslate getDepartmentTranslateByCategoryAndNameIgnoreCase(Category category, String name) {
        return crudDepartmentTranslateRepository.getDepartmentTranslateByCategoryAndNameIgnoreCase(category, name);
    }

    @Override
    public DepartmentTranslate getDepartmentByCategoryAndNameAndLanguage(Category category, String name, Language language) {
        return crudDepartmentTranslateRepository.getDepartmentTranslateByCategoryAndNameIgnoreCaseAndLanguage(category, name, language);
    }
}
