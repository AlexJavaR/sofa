package com.prototype.sofa.repository.tip;

import com.prototype.sofa.model.Tip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TipRepositoryImpl implements TipRepository {

    @Autowired
    private CrudTipRepository crudTipRepository;

    @Override
    public Tip save(Tip tip) {
        return crudTipRepository.save(tip);
    }

    @Override
    public boolean delete(int id) {
        return crudTipRepository.delete(id) != 0;
    }

    @Override
    public Tip findOne(int id) {
        return crudTipRepository.findOne(id);
    }

    @Override
    public Tip getByName(String name) {
        return crudTipRepository.getByName(name);
    }

    @Override
    public List<Tip> findAll() {
        return crudTipRepository.findAll();
    }

    @Override
    public List<Tip> getByLanguage(String language) {
        return crudTipRepository.getByLanguage(language);
    }
}
