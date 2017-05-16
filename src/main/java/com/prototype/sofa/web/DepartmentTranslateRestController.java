package com.prototype.sofa.web;

import com.prototype.sofa.model.DepartmentTranslate;
import com.prototype.sofa.service.departmentTranslate.DepartmentTranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
