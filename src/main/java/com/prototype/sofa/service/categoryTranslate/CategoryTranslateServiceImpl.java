package com.prototype.sofa.service.categoryTranslate;

import com.prototype.sofa.model.Category;
import com.prototype.sofa.model.CategoryTranslate;
import com.prototype.sofa.model.Language;
import com.prototype.sofa.repository.category.CategoryRepository;
import com.prototype.sofa.repository.categoryTranslate.CategoryTranslateRepository;
import com.prototype.sofa.repository.language.LanguageRepository;
import com.prototype.sofa.to.ToCategory;
import com.prototype.sofa.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("CategoryService")
public class CategoryTranslateServiceImpl implements CategoryTranslateService {

    @Autowired
    private CategoryTranslateRepository categoryTranslateRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public CategoryTranslate save(CategoryTranslate categoryTranslate) {
        return null;
    }

    @Override
    public CategoryTranslate findOne(int id) throws NotFoundException {
        return categoryTranslateRepository.findOne(id);
    }

    @Override
    public CategoryTranslate getByName(String name) throws NotFoundException {
        return categoryTranslateRepository.getByName(name);
    }

    @Override
    public List<CategoryTranslate> findAll() {
        return categoryTranslateRepository.findAll();
    }

    @Override
    public List<CategoryTranslate> findAllCategoriesByLanguage(String nameLanguage) {
        Language language = languageRepository.getByName(nameLanguage);
        if (language != null) {
            return categoryTranslateRepository.getAllCategoriesByLanguage(language);
        } else {
            return null;
        }
    }

    @Override
    public CategoryTranslate addCategoryToExist(ToCategory toCategory) {
        Language language = languageRepository.getByName(toCategory.getNameLanguage());
        CategoryTranslate existCategoryTranslate = categoryTranslateRepository.getByName(toCategory.getNameExistCategory());
        if (language == null || existCategoryTranslate == null) return null;
        CategoryTranslate categoryTranslate = new CategoryTranslate(toCategory.getNameCategory(), existCategoryTranslate.getCategory(), language);

        return categoryTranslateRepository.save(categoryTranslate);
    }

    @Override
    public List<CategoryTranslate> createCategoryWithFewLanguages(Map<String, String> categories) {
        List<CategoryTranslate> categoryTranslates = new ArrayList<>();
        Category category = categoryRepository.save(new Category());
        categories.forEach((key, value) -> {
            Language language = languageRepository.getByName(key);
            if (language != null) {
                CategoryTranslate categoryTranslate = categoryTranslateRepository.save(new CategoryTranslate(value, category, language));
                categoryTranslates.add(categoryTranslate);
            }
        });
        return categoryTranslates;
    }
}
