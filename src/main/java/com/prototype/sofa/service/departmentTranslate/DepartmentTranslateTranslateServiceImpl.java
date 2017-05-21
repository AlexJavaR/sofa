package com.prototype.sofa.service.departmentTranslate;

import com.prototype.sofa.model.*;
import com.prototype.sofa.repository.categoryTranslate.CategoryTranslateRepository;
import com.prototype.sofa.repository.department.DepartmentRepository;
import com.prototype.sofa.repository.departmentTranslate.DepartmentTranslateRepository;
import com.prototype.sofa.repository.language.LanguageRepository;
import com.prototype.sofa.to.ExistDepartment;
import com.prototype.sofa.to.ToDepartment;
import com.prototype.sofa.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("DepartmentTranslateService")
public class DepartmentTranslateTranslateServiceImpl implements DepartmentTranslateService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentTranslateRepository departmentTranslateRepository;

    @Autowired
    private CategoryTranslateRepository categoryTranslateRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public DepartmentTranslate save(DepartmentTranslate departmentTranslate) {
        return departmentTranslateRepository.save(departmentTranslate);
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public DepartmentTranslate findOne(int id) throws NotFoundException {
        return departmentTranslateRepository.findOne(id);
    }

    @Override
    public DepartmentTranslate getByName(String name) throws NotFoundException {
        return null;
    }

    @Override
    public List<DepartmentTranslate> findAll() {
        return departmentTranslateRepository.findAll();
    }

    @Override
    public void update(DepartmentTranslate departmentTranslate) {

    }

    @Override
    public List<DepartmentTranslate> getAllDepartmentByLanguage(String nameLanguage) {
        Language language = languageRepository.getByName(nameLanguage);
        return departmentTranslateRepository.getAllDepartmentByLanguage(language);
    }

    @Override
    public List<DepartmentTranslate> getAllDepartmentByLanguageAndName(String nameLanguage, String nameCategory) {
        Language language = languageRepository.getByName(nameLanguage);
        Category category = categoryTranslateRepository.getByName(nameCategory).getCategory();
        return departmentTranslateRepository.getAllDepartmentByLanguageAndName(language, category);
    }

    @Override
    public DepartmentTranslate getDepartmentByLanguageAndCategoryAndName(String nameLanguage, String nameCategory, String nameDepartment) {
        Language language = languageRepository.getByName(nameLanguage);
        Category category = categoryTranslateRepository.getByName(nameCategory).getCategory();

        return departmentTranslateRepository.getDepartmentByLanguageAndCategoryAndName(language, category, nameDepartment);
    }

    @Override
    public DepartmentTranslate addDepartmentToExist(ExistDepartment existDepartment) {
        Language language = languageRepository.getByName(existDepartment.getNameLanguageDepartment());
        Category existCategory = categoryTranslateRepository.getByName(existDepartment.getNameCategoryDepartmentExist()).getCategory();
        Department department = departmentTranslateRepository.getDepartmentTranslateByCategoryAndNameIgnoreCase(existCategory, existDepartment.getNameDepartmentExist()).getDepartment();
        if (language == null || existCategory == null || department == null) return null;
        DepartmentTranslate departmentTranslate = new DepartmentTranslate(existDepartment.getNameDepartment(), existCategory, language, department);

        return departmentTranslateRepository.save(departmentTranslate);
    }

    @Override
    public List<DepartmentTranslate> createDepartmentWithFewLanguages(List<ToDepartment> toDepartments) {
        List<DepartmentTranslate> departmentTranslates = new ArrayList<>();
        Department department = departmentRepository.save(new Department());
        toDepartments.forEach(toDepartment -> {
            Language language = languageRepository.getByName(toDepartment.getNameLanguage());
            Category category = categoryTranslateRepository.getByName(toDepartment.getNameCategory()).getCategory();
            if (language != null && category != null) {
                DepartmentTranslate departmentTranslate = departmentTranslateRepository.save(new DepartmentTranslate(toDepartment.getNameDepartment(),
                        category, language, department));
                departmentTranslates.add(departmentTranslate);
            }
        });
        return departmentTranslates;
    }
}
