package com.prototype.sofa.service.tip;

import com.prototype.sofa.model.Tip;
import com.prototype.sofa.repository.tip.TipRepository;
import com.prototype.sofa.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TipService")
public class TipServiceImpl implements TipService {

    @Autowired
    private TipRepository tipRepository;

    @Override
    public Tip save(Tip tip) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Tip findOne(int id) throws NotFoundException {
        return null;
    }

    @Override
    public Tip getByName(String name) throws NotFoundException {
        return null;
    }

    @Override
    public List<Tip> findAll() {
        return tipRepository.findAll();
    }

    @Override
    public void update(Tip tip) {

    }

    @Override
    public List<Tip> getByLanguage(String language) {
        return tipRepository.getByLanguage(language);
    }
}
