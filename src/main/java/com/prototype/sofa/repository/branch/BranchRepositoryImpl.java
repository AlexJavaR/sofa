package com.prototype.sofa.repository.branch;

import com.prototype.sofa.model.Branch;
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
    public List<Branch> getAllBranchesByRadius(Double radius, Double latitude, Double longitude) {
        return crudBranchRepository.getAllBranchesByRadius(radius, latitude, longitude);
    }
}
