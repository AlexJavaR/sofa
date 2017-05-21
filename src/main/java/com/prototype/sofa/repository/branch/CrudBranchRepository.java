package com.prototype.sofa.repository.branch;

import com.prototype.sofa.model.Branch;
import com.prototype.sofa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudBranchRepository extends JpaRepository<Branch, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Branch b WHERE b.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Branch save(Branch branch);

    @Override
    Branch findOne(Integer id);

    @Override
    @Query("SELECT b FROM Branch b ORDER BY b.placeId")
    List<Branch> findAll();

    @Query("SELECT b FROM Branch b WHERE b.id=?1")
    Branch getByName(String name);

    @Query(value = "SELECT * FROM branches WHERE ST_Distance(location, ST_MakePoint(:latitude, :longitude)) <= :radius * 1000 " +
            "ORDER BY ST_Distance(location, ST_MakePoint(:latitude, :longitude))", nativeQuery = true)
    List<Branch> getAllBranchesByRadius(@Param("latitude") Double latitude, @Param("longitude") Double longitude, @Param("radius") Double radius);

    @Query("SELECT b FROM Branch b WHERE b.department=:department")
    List<Branch> getAllBranchesByDepartment(@Param("department") Department department);

    @Modifying
    @Transactional
    @Query(value = "UPDATE branches SET location = ST_MakePoint(latitude, longitude) WHERE id = :id", nativeQuery = true)
    void addLocationToBranch(@Param("id") Integer id);
}
