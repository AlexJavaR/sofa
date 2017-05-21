package com.prototype.sofa.repository.branch;

import com.prototype.sofa.model.Branch;
import com.prototype.sofa.model.Department;

import java.util.List;

public interface BranchRepository {
    Branch save(Branch branch);

    // false if not found
    boolean delete(int id);

    // null if not found
    Branch findOne(int id);

    // null if not found
    Branch getByName(String name);

    List<Branch> findAll();

    List<Branch> getAllBranchesByRadius(Double latitude, Double longitude, Double radius);

    List<Branch> getAllBranchesByDepartment(Department department);

    void addLocationToBranch(Integer id, Double latitude, Double longitude);
}
