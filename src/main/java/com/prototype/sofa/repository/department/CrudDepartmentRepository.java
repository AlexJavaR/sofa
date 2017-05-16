package com.prototype.sofa.repository.department;

import com.prototype.sofa.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudDepartmentRepository extends JpaRepository<Department, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Department d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Department save(Department department);

    @Override
    Department findOne(Integer id);

    @Override
    @Query("SELECT d FROM Department d ORDER BY d.id")
    List<Department> findAll();
}
