package com.prototype.sofa.web;

import com.prototype.sofa.model.CategoryTranslate;
import com.prototype.sofa.service.categoryTranslate.CategoryTranslateService;
import com.prototype.sofa.to.ExistCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = CategoryTranslateRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryTranslateRestController {
    static final String REST_URL = "/category";

    @Autowired
    private CategoryTranslateService categoryTranslateService;

    @GetMapping(value = "/all")
    public List<CategoryTranslate> getAll() {
        return categoryTranslateService.findAll();
    }

    @GetMapping(value = "/all/{nameLanguage}")
    public List<CategoryTranslate> getAllCategoriesByLanguage(@PathVariable("nameLanguage") String nameLanguage) {
        return categoryTranslateService.findAllCategoriesByLanguage(nameLanguage);
    }

    @GetMapping(value = "/name/{nameCategory}")
    public List<CategoryTranslate> getCategoryWithAllLanguagesByName(@PathVariable("nameCategory") String nameCategory) {
        return categoryTranslateService.getCategoryWithAllLanguagesByName(nameCategory);
    }

    @GetMapping(value = "/id/{id}")
    public List<CategoryTranslate> getCategoryWithAllLanguagesById(@PathVariable("id") Integer id) {
        return categoryTranslateService.getCategoryWithAllLanguagesById(id);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryTranslate>> createCategoryWithFewLanguages(@RequestBody Map<String, String> categories) {
        List<CategoryTranslate> categoryTranslateList = categoryTranslateService.createCategoryWithFewLanguages(categories);
        return new ResponseEntity<>(categoryTranslateList, HttpStatus.CREATED);
    }

    @PutMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryTranslate> addCategoryToExist(@RequestBody ExistCategory existCategory) {
        CategoryTranslate categoryTranslate = categoryTranslateService.addCategoryToExist(existCategory);
        if (categoryTranslate == null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<>(categoryTranslate, HttpStatus.CREATED);
    }
}
