package com.prototype.sofa.repository.department;

import com.prototype.sofa.model.Department;

import java.util.List;

public interface DepartmentRepository {
    Department save(Department department);

    // false if not found
    boolean delete(int id);

    // null if not found
    Department findOne(int id);

    List<Department> findAll();
}
