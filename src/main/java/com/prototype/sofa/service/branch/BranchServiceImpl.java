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

        Category category = categoryTranslateRepository.getByName(toBranch.getNameCategory()).getCategory();
        if (category == null) {
            return null;
            //categoryTranslate = categoryTranslateRepository.save(new CategoryTranslate(toBranch.getNameCategory(), new Category(), language));
        }

        DepartmentTranslate departmentTranslate =
                departmentTranslateRepository.getDepartmentByLanguageAndCategoryAndName(language, category, toBranch.getNameDepartment());
        Department department;
        if (departmentTranslate == null) {
            department = departmentRepository.save(new Department());
            departmentTranslate = departmentTranslateRepository.save(new DepartmentTranslate(toBranch.getNameDepartment(), category, language, department));
        } else {
            department = departmentTranslate.getDepartment();
        }
        Branch branch = new Branch(toBranch.getPlaceId(), toBranch.getLatitude(),
                        toBranch.getLongitude(), toBranch.getPhoneNumber(), toBranch.getOpenHours(), null);
        branch.setDepartment(department);
        //branch.setLocation(new Point(branch.getLatitude(), branch.getLongitude()));

        departmentTranslate.getDepartment().getBranches().add(branch);
        departmentTranslateRepository.save(departmentTranslate);
        branch = branchRepository.save(branch);

        branchRepository.addLocationToBranch(branch.getId(), branch.getLatitude(), branch.getLongitude());
        branch = branchRepository.findOne(branch.getId());

        return branch;
    }

    @Override
    public DepartmentTranslate getDepartmentTranslateByBranch(ToBranch toBranch) {
        Language language = languageRepository.getByName(toBranch.getNameLanguage());
        Category category = categoryTranslateRepository.getByName(toBranch.getNameCategory()).getCategory();
        return departmentTranslateRepository.getDepartmentByLanguageAndCategoryAndName(language, category, toBranch.getNameDepartment());
    }

    @Override
    public List<Branch> getAllBranchesByCategoryAndDepartment(String nameLanguage, String nameCategory, String nameDepartment) {
        Language language = languageRepository.getByName(nameLanguage);
        Category category = categoryTranslateRepository.getByName(nameCategory).getCategory();
        DepartmentTranslate departmentTranslate = departmentTranslateRepository.getDepartmentByLanguageAndCategoryAndName(language, category, nameDepartment);
        Department department = departmentTranslate.getDepartment();
        List<Branch> branches = branchRepository.getAllBranchesByDepartment(department);
        if (branches.isEmpty()) return null;
        else return branches;
    }

    @Override
    public List<Branch> getAllBranchesByRadius(Double latitude, Double longitude, Double radius) {
        return branchRepository.getAllBranchesByRadius(latitude, longitude, radius);
    }
}
