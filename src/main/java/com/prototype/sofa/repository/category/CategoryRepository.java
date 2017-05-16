package com.prototype.sofa.repository.category;

import com.prototype.sofa.model.Category;
import com.prototype.sofa.model.Language;

import java.util.List;

public interface CategoryRepository {
    Category save(Category category);

    // false if not found
    boolean delete(int id);

    // null if not found
    Category findOne(int id);

    // null if not found
    //Category getByName(String name);

    List<Category> findAll();

    //List<Category> getAllCategoriesByLanguage(Language language);
}
