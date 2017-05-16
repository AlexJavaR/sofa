package com.prototype.sofa.repository.branch;

import com.prototype.sofa.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudBranchRepository extends JpaRepository<Branch, Integer> {
    String HAVERSINE_PART = "(6371 * acos(cos(radians(?2)) * cos(radians(b.latitude)) * cos(radians(b.longitude) - radians(?3)) + sin(radians(?2)) * sin(radians(b.latitude))))";

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

    @Query("SELECT b FROM Branch b WHERE " + HAVERSINE_PART + " < ?1 ORDER BY " + HAVERSINE_PART + " DESC")
    List<Branch> getAllBranchesByRadius(Double radius, Double latitude, Double longitude);
}
