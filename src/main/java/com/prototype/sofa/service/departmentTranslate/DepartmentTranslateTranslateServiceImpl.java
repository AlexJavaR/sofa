package com.prototype.sofa.service.departmentTranslate;

import com.prototype.sofa.model.Category;
import com.prototype.sofa.model.CategoryTranslate;
import com.prototype.sofa.model.DepartmentTranslate;
import com.prototype.sofa.model.Language;
import com.prototype.sofa.repository.category.CategoryRepository;
import com.prototype.sofa.repository.categoryTranslate.CategoryTranslateRepository;
import com.prototype.sofa.repository.departmentTranslate.DepartmentTranslateRepository;
import com.prototype.sofa.repository.language.LanguageRepository;
import com.prototype.sofa.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DepartmentTranslateService")
public class DepartmentTranslateTranslateServiceImpl implements DepartmentTranslateService {

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
    public DepartmentTranslate getDepartmentByCategoryAndNameAndLanguage(String category, String name, String language) {
        Language lang = languageRepository.getByName(language);
        CategoryTranslate categoryTranslate = categoryTranslateRepository.getByName(category);

        return departmentTranslateRepository.getDepartmentByCategoryAndNameAndLanguage(categoryTranslate.getCategory(), name, lang);
    }
}
