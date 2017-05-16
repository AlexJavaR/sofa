package com.prototype.sofa.service.language;

import com.prototype.sofa.model.Language;
import com.prototype.sofa.util.exception.NotFoundException;

import java.util.List;

public interface LanguageService {
    Language save(Language language);

    Language findOne(int id) throws NotFoundException;

    Language getByName(String name) throws NotFoundException;

    List<Language> findAll();

    Language addLanguage(String nameLanguage);
}
