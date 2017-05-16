package com.prototype.sofa.repository.department;

import com.prototype.sofa.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {
    @Autowired
    private CrudDepartmentRepository crudDepartmentRepository;

    @Override
    public Department save(Department department) {
        return crudDepartmentRepository.save(department);
    }

    @Override
    public boolean delete(int id) {
        return crudDepartmentRepository.delete(id) != 0;
    }

    @Override
    public Department findOne(int id) {
        return crudDepartmentRepository.findOne(id);
    }

    @Override
    public List<Department> findAll() {
        return crudDepartmentRepository.findAll();
    }
}
