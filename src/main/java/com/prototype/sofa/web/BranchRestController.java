package com.prototype.sofa.web;

import com.prototype.sofa.model.Branch;
import com.prototype.sofa.service.branch.BranchService;
import com.prototype.sofa.to.ToBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = BranchRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class BranchRestController {
    static final String REST_URL = "/branch";

    @Autowired
    private BranchService branchService;

    @GetMapping(value = "/all")
    public List<Branch> getAll() {
        return branchService.getAll();
    }

    @GetMapping(value = "/all/{nameLanguage}/{nameCategory}/{nameDepartment}")
    public List<Branch> getAllBranchesByCategoryAndDepartment(@PathVariable("nameLanguage") String nameLanguage,
                                                              @PathVariable("nameCategory") String nameCategory,
                                                              @PathVariable("nameDepartment") String nameDepartment) {
        return branchService.getAllBranchesByCategoryAndDepartment(nameLanguage, nameCategory, nameDepartment);
    }

    @GetMapping(value = "/radius/{latitude}/{longitude}/{radius}")
    public List<Branch> getAllBranchesByRadius(@PathVariable("latitude") Double latitude,
                                               @PathVariable("longitude") Double longitude,
                                               @PathVariable("radius") Double radius) {
        return branchService.getAllBranchesByRadius(latitude, longitude, radius);
    }

    @GetMapping(value = "/radius/{nameCategory}/{latitude}/{longitude}/{radius}")
    public List<Branch> getAllBranchesByCategoryAndRadius(@PathVariable("nameCategory") String nameCategory, @PathVariable("latitude") Double latitude,
                                                          @PathVariable("longitude") Double longitude, @PathVariable("radius") Double radius) {
        return branchService.getAllBranchesByCategoryAndRadius(nameCategory, latitude, longitude, radius);
    }

    @GetMapping(value = "/radius/{nameCategory}/{nameDepartment}/{latitude}/{longitude}/{radius}")
    public List<Branch> getAllBranchesByCategoryAndDepartmentAndRadius(@PathVariable("nameCategory") String nameCategory,
                                                                       @PathVariable("nameDepartment") String nameDepartment,
                                                                       @PathVariable("latitude") Double latitude,
                                                                       @PathVariable("longitude") Double longitude,
                                                                       @PathVariable("radius") Double radius) {
        return branchService.getAllBranchesByCategoryAndDepartmentAndRadius(nameCategory, nameDepartment, latitude, longitude, radius);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Branch> addBranch(@RequestBody ToBranch toBranch) {
        Branch branch = branchService.addBranch(toBranch);
        if (branch == null) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(branch, HttpStatus.CREATED);
    }
}
