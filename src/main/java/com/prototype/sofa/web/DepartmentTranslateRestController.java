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

    @GetMapping(value = "/{category}/{name}/{language}")
    public DepartmentTranslate getDepartmentTranslateByName(@PathVariable("category") String category,
                                                            @PathVariable("name") String name,
                                                            @PathVariable("language") String language) {
        return departmentTranslateService.getDepartmentByCategoryAndNameAndLanguage(category, name, language);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<DepartmentTranslate>> createDepartmentWithFewLanguages(@RequestBody List<ToDepartment> toDepartments) {
        List<DepartmentTranslate> departmentTranslateList = departmentTranslateService.createDepartmentWithFewLanguages(toDepartments);
        return new ResponseEntity<>(departmentTranslateList, HttpStatus.CREATED);
    }

    @PutMapping(value = "/create")
    public ResponseEntity<DepartmentTranslate> addDepartmentToExist(@RequestBody ExistDepartment existDepartment) {
        DepartmentTranslate departmentTranslate = departmentTranslateService.addDepartmentToExist(existDepartment);
        if (departmentTranslate == null)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        else
            return new ResponseEntity<>(departmentTranslate, HttpStatus.CREATED);
    }
}
