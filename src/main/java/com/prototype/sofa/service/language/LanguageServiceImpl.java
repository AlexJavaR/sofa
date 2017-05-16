package com.prototype.sofa.service.language;

import com.prototype.sofa.model.Language;
import com.prototype.sofa.repository.language.LanguageRepository;
import com.prototype.sofa.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LanguageService")
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Override
    public Language save(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language findOne(int id) throws NotFoundException {
        return languageRepository.findOne(id);
    }

    @Override
    public Language getByName(String name) throws NotFoundException {
        return languageRepository.getByName(name);
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Language addLanguage(String nameLanguage) {
        Language language = languageRepository.getByName(nameLanguage);

        if (language == null) {
            return languageRepository.save(new Language(nameLanguage));
        } else {
            return null;
        }
    }
}
