package com.prototype.sofa.repository.tip;

import com.prototype.sofa.model.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudTipRepository extends JpaRepository<Tip, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Tip t WHERE t.id=:id")
    int delete(@Param("id") int id);

    @Override
    @Transactional
    Tip save(Tip tip);

    @Override
    Tip findOne(Integer id);

    @Override
    @Query("SELECT t FROM Tip t ORDER BY t.name")
    List<Tip> findAll();

    @Query("SELECT t FROM Tip t WHERE t.name=?1")
    Tip getByName(String name);

    @Query("SELECT t FROM Tip t WHERE t.language.name=?1")
    List<Tip> getByLanguage(String language);
}
