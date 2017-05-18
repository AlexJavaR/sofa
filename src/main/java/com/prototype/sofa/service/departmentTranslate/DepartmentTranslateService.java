package com.prototype.sofa.service.departmentTranslate;

import com.prototype.sofa.model.DepartmentTranslate;
import com.prototype.sofa.to.ExistDepartment;
import com.prototype.sofa.to.ToDepartment;
import com.prototype.sofa.util.exception.NotFoundException;

import java.util.List;

public interface DepartmentTranslateService {
    DepartmentTranslate save(DepartmentTranslate departmentTranslate);

    void delete(int id) throws NotFoundException;

    DepartmentTranslate findOne(int id) throws NotFoundException;

    DepartmentTranslate getByName(String name) throws NotFoundException;

    List<DepartmentTranslate> findAll();

    void update(DepartmentTranslate departmentTranslate);

    DepartmentTranslate getDepartmentByCategoryAndNameAndLanguage(String category, String name, String language);

    DepartmentTranslate addDepartmentToExist(ExistDepartment existDepartment);

    List<DepartmentTranslate> createDepartmentWithFewLanguages(List<ToDepartment> toDepartments);
}
