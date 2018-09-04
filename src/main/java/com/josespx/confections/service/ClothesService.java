package com.josespx.confections.service;

import com.josespx.confections.dao.Dao;
import com.josespx.confections.model.Clothes;

import java.util.List;

public interface ClothesService extends Dao<Clothes, Long> {

    @Override
    void save(Clothes clothes);

    @Override
    void deleteById(Long id);

    @Override
    List<Clothes> findAll();

    @Override
    Clothes findById(Long id);


}
