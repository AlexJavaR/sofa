package com.prototype.sofa.service.tip;

import com.prototype.sofa.model.Tip;
import com.prototype.sofa.util.exception.NotFoundException;

import java.util.List;

public interface TipService {
    Tip save(Tip tip);

    void delete(int id) throws NotFoundException;

    Tip findOne(int id) throws NotFoundException;

    Tip getByName(String name) throws NotFoundException;

    List<Tip> findAll();

    void update(Tip tip);

    List<Tip> getByLanguage(String language);
}
