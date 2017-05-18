package com.prototype.sofa.repository.categoryTranslate;

import com.prototype.sofa.model.Category;
import com.prototype.sofa.model.CategoryTranslate;
import com.prototype.sofa.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudCategoryTranslateRepository extends JpaRepository<CategoryTranslate, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM CategoryTranslate c WHERE c.id=?1")
    int delete(int id);

    @Override
    @Transactional
    CategoryTranslate save(CategoryTranslate categoryTranslate);

    @Override
    CategoryTranslate findOne(Integer id);

    @Override
    @Query("SELECT c FROM CategoryTranslate c ORDER BY c.name")
    List<CategoryTranslate> findAll();

    List<CategoryTranslate> getAllCategoriesByLanguage(Language language);

    //@Query("SELECT c FROM CategoryTranslate c WHERE c.name=?1")
    CategoryTranslate getByNameIgnoreCase(String name);

    @Query("SELECT c FROM CategoryTranslate c WHERE c.category=?1")
    List<CategoryTranslate> findAllCategoryTranslateByCategory(Category category);
}
