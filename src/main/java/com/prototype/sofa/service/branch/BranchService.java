package com.prototype.sofa.service.branch;

import com.prototype.sofa.model.Branch;
import com.prototype.sofa.model.DepartmentTranslate;
import com.prototype.sofa.to.ToBranch;
import com.prototype.sofa.util.exception.NotFoundException;

import java.util.List;

public interface BranchService {
    Branch save(Branch branch);

    void delete(int id) throws NotFoundException;

    Branch get(int id) throws NotFoundException;

    Branch getByName(String name) throws NotFoundException;

    List<Branch> getAll();

    void update(Branch branch);

    Branch addBranch(ToBranch toBranch);

    DepartmentTranslate getDepartmentTranslateByBranch(ToBranch toBranch);

    List<Branch> getAllBranchesByCategoryAndDepartment(String nameLanguage, String nameCategory, String nameDepartment);

    List<Branch> getAllBranchesByRadius(Double latitude, Double longitude, Double radius);

    List<Branch> getAllBranchesByCategoryAndRadius(String nameCategory, Double latitude, Double longitude, Double radius);

    List<Branch> getAllBranchesByCategoryAndDepartmentAndRadius(String nameCategory, String nameDepartment, Double latitude, Double longitude, Double radius);
}
