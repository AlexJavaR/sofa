package com.prototype.sofa.repository.language;

import com.prototype.sofa.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CrudLanguageRepository extends JpaRepository<Language, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Language l WHERE l.id=?1")
    int delete(int id);

    @Override
    @Transactional
    Language save(Language language);

    @Override
    Language findOne(Integer id);

    @Override
    @Query("SELECT l FROM Language l ORDER BY l.name")
    List<Language> findAll();

    @Query("SELECT l FROM Language l WHERE l.name=?1")
    Language getByName(String name);
}
