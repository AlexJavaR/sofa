package com.prototype.sofa.web;

import com.prototype.sofa.model.Branch;
import com.prototype.sofa.service.branch.BranchService;
import com.prototype.sofa.to.ToBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @GetMapping(value = "/all/{category}/{name}")
    public List<Branch> getAllBranchesByNameAndCategory(@PathVariable("category") String nameCategory, @PathVariable("name") String nameDepartment) {
        return branchService.getAllBranchesByCategoryAndNameDepartment(nameCategory, nameDepartment);
    }

    @GetMapping(value = "/all/radius")
    public List<Branch> getAllBranchesByRadius(@RequestParam(value = "radius", required = false) Double radius,
                                               @RequestParam(value = "latitude", required = false) Double latitude,
                                               @RequestParam(value = "longitude", required = false) Double longitude) {
        return branchService.getAllBranchesByRadius(radius, latitude, longitude);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Branch addBranch(@RequestBody ToBranch toBranch) {
        return branchService.addBranch(toBranch);
    }
}
