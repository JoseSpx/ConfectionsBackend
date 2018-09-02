package com.josespx.confections.dao;

import com.josespx.confections.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClothesDao extends JpaRepository<Clothes, Long> {

    List<Clothes> findAllByEliminatedEquals(String eliminated);

}
