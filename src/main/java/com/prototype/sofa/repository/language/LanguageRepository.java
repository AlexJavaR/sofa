package com.prototype.sofa.repository.language;

import com.prototype.sofa.model.Language;

import java.util.List;

public interface LanguageRepository {
    Language save(Language language);

    // false if not found
    boolean delete(int id);

    // null if not found
    Language findOne(int id);

    // null if not found
    Language getByName(String name);

    List<Language> findAll();
}
