package com.prototype.sofa.repository.tip;

import com.prototype.sofa.model.Tip;

import java.util.List;

public interface TipRepository {
    Tip save(Tip tip);

    // false if not found
    boolean delete(int id);

    // null if not found
    Tip findOne(int id);

    // null if not found
    Tip getByName(String name);

    List<Tip> findAll();

    List<Tip> getByLanguage(String language);
}
