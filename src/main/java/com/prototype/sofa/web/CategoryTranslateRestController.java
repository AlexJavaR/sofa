package com.prototype.sofa.web;

import com.prototype.sofa.model.Category;
import com.prototype.sofa.model.CategoryTranslate;
import com.prototype.sofa.model.Language;
import com.prototype.sofa.service.categoryTranslate.CategoryTranslateService;
import com.prototype.sofa.to.ToCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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

    @GetMapping(value = "/all/{language}")
    public List<CategoryTranslate> getAllCategoriesByLanguage(@PathVariable("language") String nameLanguage) {
        return categoryTranslateService.findAllCategoriesByLanguage(nameLanguage);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<CategoryTranslate>> createCategoryWithFewLanguages(@RequestBody Map<String, String> categories) {
        List<CategoryTranslate> categoryTranslateList = categoryTranslateService.createCategoryWithFewLanguages(categories);
        return new ResponseEntity<>(categoryTranslateList, HttpStatus.CREATED);
    }

    @PutMapping(value = "/create")
    public ResponseEntity<CategoryTranslate> addCategoryToExist(@RequestBody ToCategory toCategory) {
        CategoryTranslate categoryTranslate = categoryTranslateService.addCategoryToExist(toCategory);
        if (categoryTranslate == null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<>(categoryTranslate, HttpStatus.CREATED);
    }
}
