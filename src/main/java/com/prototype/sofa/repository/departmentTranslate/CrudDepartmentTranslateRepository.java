package com.prototype.sofa.repository.departmentTranslate;

import com.prototype.sofa.model.Category;
import com.prototype.sofa.model.DepartmentTranslate;
import com.prototype.sofa.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudDepartmentTranslateRepository extends JpaRepository<DepartmentTranslate, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM DepartmentTranslate d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    DepartmentTranslate save(DepartmentTranslate departmentTranslate);

    @Override
    DepartmentTranslate findOne(Integer id);

    @Override
    @Query("SELECT d FROM DepartmentTranslate d ORDER BY d.id")
    List<DepartmentTranslate> findAll();

    List<DepartmentTranslate> getAllDepartmentByLanguage(Language language);

    List<DepartmentTranslate> getAllDepartmentByLanguageAndCategory(Language language, Category category);

    DepartmentTranslate getDepartmentTranslateByCategoryAndNameIgnoreCase(Category category, String name);

    DepartmentTranslate getDepartmentTranslateByLanguageAndCategoryAndNameIgnoreCase(Language language, Category category, String name);
}
