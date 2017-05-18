package com.prototype.sofa.repository.branch;

import com.prototype.sofa.model.Branch;

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
}
