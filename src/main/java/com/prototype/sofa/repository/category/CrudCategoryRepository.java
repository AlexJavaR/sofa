package com.prototype.sofa.repository.category;

import com.prototype.sofa.model.Category;
import com.prototype.sofa.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudCategoryRepository extends JpaRepository<Category, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Category c WHERE c.id=?1")
    int delete(int id);

    @Override
    @Transactional
    Category save(Category category);

    @Override
    Category findOne(Integer id);

    @Override
    @Query("SELECT c FROM Category c ORDER BY c.id")
    List<Category> findAll();

    //List<Category> getAllCategoriesByLanguage(Language language);

    //@Query("SELECT c FROM Category c WHERE c.name=?1")
    //Category getByNameIgnoreCase(String name);
}
