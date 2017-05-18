package com.prototype.sofa.service.branch;

import com.prototype.sofa.model.*;
import com.prototype.sofa.repository.branch.BranchRepository;
import com.prototype.sofa.repository.categoryTranslate.CategoryTranslateRepository;
import com.prototype.sofa.repository.department.DepartmentRepository;
import com.prototype.sofa.repository.departmentTranslate.DepartmentTranslateRepository;
import com.prototype.sofa.repository.language.LanguageRepository;
import com.prototype.sofa.to.ToBranch;
import com.prototype.sofa.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BranchService")
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentTranslateRepository departmentTranslateRepository;

    @Autowired
    private CategoryTranslateRepository categoryTranslateRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Branch save(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Branch get(int id) throws NotFoundException {
        return branchRepository.findOne(id);
    }

    @Override
    public Branch getByName(String name) throws NotFoundException {
        return null;
    }

    @Override
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    @Override
    public void update(Branch user) {

    }

    @Override
    public Branch addBranch(ToBranch toBranch) {
        Language language = languageRepository.getByName(toBranch.getNameLanguage());
        if (language == null) {
            return null;
        }

        CategoryTranslate categoryTranslate = categoryTranslateRepository.getByName(toBranch.getNameCategory());
        if (categoryTranslate == null) {
            return null;
            //categoryTranslate = categoryTranslateRepository.save(new CategoryTranslate(toBranch.getNameCategory(), new Category(), language));
        }

        DepartmentTranslate departmentTranslate =
                departmentTranslateRepository.getDepartmentByCategoryAndNameAndLanguage(categoryTranslate.getCategory(), toBranch.getNameDepartment(), language);
        Department department;
        if (departmentTranslate == null) {
            department = departmentRepository.save(new Department());
            departmentTranslate = departmentTranslateRepository.save(new DepartmentTranslate(toBranch.getNameDepartment(),
                    categoryTranslate.getCategory(), language, department));
        } else {
            department = departmentTranslate.getDepartment();
        }
        Branch branch = new Branch(toBranch.getPlaceId(), toBranch.getLatitude(),
                        toBranch.getLongitude(), toBranch.getPhoneNumber(), toBranch.getOpenHours());
        branch.setDepartment(department);

        departmentTranslate.getDepartment().getBranches().add(branch);
        departmentTranslateRepository.save(departmentTranslate);
        branch = branchRepository.save(branch);

        return branch;
    }

    @Override
    public DepartmentTranslate getDepartmentTranslateByBranch(ToBranch toBranch) {
        Language language = languageRepository.getByName(toBranch.getNameLanguage());
        CategoryTranslate categoryTranslate = categoryTranslateRepository.getByName(toBranch.getNameCategory());
        return departmentTranslateRepository.getDepartmentByCategoryAndNameAndLanguage(categoryTranslate.getCategory(), toBranch.getNameDepartment(), language);
    }

    @Override
    public List<Branch> getAllBranchesByCategoryAndNameDepartment(String nameCategory, String nameDepartment) {
        CategoryTranslate categoryTranslate = categoryTranslateRepository.getByName(nameCategory);
        DepartmentTranslate departmentTranslate = departmentTranslateRepository.getDepartmentTranslateByCategoryAndNameIgnoreCase(categoryTranslate.getCategory(), nameDepartment);

        return departmentTranslate.getDepartment().getBranches();
    }

    @Override
    public List<Branch> getAllBranchesByRadius(Double latitude, Double longitude, Double radius) {
        return branchRepository.getAllBranchesByRadius(latitude, longitude, radius);
    }
}
