package com.prototype.sofa.repository.branch;

import com.prototype.sofa.model.Branch;
import com.prototype.sofa.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchRepositoryImpl implements BranchRepository {

    @Autowired
    private CrudBranchRepository crudBranchRepository;

    @Override
    public Branch save(Branch branch) {
        return crudBranchRepository.save(branch);
    }

    @Override
    public boolean delete(int id) {
        return crudBranchRepository.delete(id) != 0;
    }

    @Override
    public Branch findOne(int id) {
        return crudBranchRepository.findOne(id);
    }

    @Override
    public Branch getByName(String name) {
        return crudBranchRepository.getByName(name);
    }

    @Override
    public List<Branch> findAll() {
        return crudBranchRepository.findAll();
    }

    @Override
    public List<Branch> getAllBranchesByDepartment(Department department) {
        List<Branch> branches = crudBranchRepository.getAllBranchesByDepartment(department);
        return branches;
    }

    @Override
    public List<Branch> getAllBranchesByRadius(Double latitude, Double longitude, Double radius) {
        return crudBranchRepository.getAllBranchesByRadius(latitude, longitude, radius);
    }

    @Override
    public List<Branch> getAllBranchesByCategoryAndRadius(Integer categoryId, Double latitude, Double longitude, Double radius) {
        return crudBranchRepository.getAllBranchesByCategoryAndRadius(categoryId, latitude, longitude, radius);
    }

    @Override
    public List<Branch> getAllBranchesByCategoryAndDepartmentAndRadius(Integer categoryId, Integer departmentId, Double latitude, Double longitude, Double radius) {
        return crudBranchRepository.getAllBranchesByCategoryAndDepartmentAndRadius(categoryId, departmentId, latitude, longitude, radius);
    }

    @Override
    public void addLocationToBranch(Integer id, Double latitude, Double longitude) {
        crudBranchRepository.addLocationToBranch(id);
    }
}
