package com.prototype.sofa.web;

import com.prototype.sofa.model.DepartmentTranslate;
import com.prototype.sofa.service.departmentTranslate.DepartmentTranslateService;
import com.prototype.sofa.to.ExistDepartment;
import com.prototype.sofa.to.ToDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = DepartmentTranslateRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentTranslateRestController {
    static final String REST_URL = "/department";

    @Autowired
    private DepartmentTranslateService departmentTranslateService;

    @GetMapping(value = "/all")
    public List<DepartmentTranslate> getAll() {
        return departmentTranslateService.findAll();
    }

    @GetMapping(value = "/all/{nameLanguage}")
    public List<DepartmentTranslate> getAll(@PathVariable("nameLanguage") String nameLanguage) {
        return departmentTranslateService.getAllDepartmentByLanguage(nameLanguage);
    }

    @GetMapping(value = "/all/{nameLanguage}/{nameCategory}")
    public List<DepartmentTranslate> getAll(@PathVariable("nameLanguage") String nameLanguage,
                                            @PathVariable("nameCategory") String nameCategory) {
        return departmentTranslateService.getAllDepartmentByLanguageAndName(nameLanguage, nameCategory);
    }

    @GetMapping(value = "/{nameLanguage}/{nameCategory}/{nameDepartment}")
    public DepartmentTranslate getDepartmentTranslateByName(@PathVariable("nameLanguage") String nameLanguage,
                                                            @PathVariable("nameCategory") String nameCategory,
                                                            @PathVariable("nameDepartment") String nameDepartment) {
        return departmentTranslateService.getDepartmentByLanguageAndCategoryAndName(nameLanguage, nameCategory, nameDepartment);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentTranslate>> createDepartmentWithFewLanguages(@RequestBody List<ToDepartment> toDepartments) {
        List<DepartmentTranslate> departmentTranslateList = departmentTranslateService.createDepartmentWithFewLanguages(toDepartments);
        return new ResponseEntity<>(departmentTranslateList, HttpStatus.CREATED);
    }

    @PutMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentTranslate> addDepartmentToExist(@RequestBody ExistDepartment existDepartment) {
        DepartmentTranslate departmentTranslate = departmentTranslateService.addDepartmentToExist(existDepartment);
        if (departmentTranslate == null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<>(departmentTranslate, HttpStatus.CREATED);
    }
}
