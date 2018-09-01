package com.josespx.confections.dao;

import com.josespx.confections.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesDao extends JpaRepository<Clothes, Long> {
}
