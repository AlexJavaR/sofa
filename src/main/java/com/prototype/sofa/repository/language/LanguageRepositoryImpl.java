package com.prototype.sofa.repository.language;

import com.prototype.sofa.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {

    @Autowired
    private CrudLanguageRepository crudLanguageRepository;

    @Override
    public Language save(Language language) {
        return crudLanguageRepository.save(language);
    }

    @Override
    public boolean delete(int id) {
        return crudLanguageRepository.delete(id) != 0;
    }

    @Override
    public Language findOne(int id) {
        return crudLanguageRepository.findOne(id);
    }

    @Override
    public Language getByName(String name) {
        return crudLanguageRepository.getByName(name);
    }

    @Override
    public List<Language> findAll() {
        return crudLanguageRepository.findAll();
    }
}
