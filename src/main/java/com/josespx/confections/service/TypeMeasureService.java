package com.josespx.confections.service;

import com.josespx.confections.dao.Dao;
import com.josespx.confections.model.TypeMeasure;

import java.util.List;

public interface TypeMeasureService extends Dao<TypeMeasure, Long> {

    @Override
    void save(TypeMeasure typeMeasure);

    @Override
    void deleteById(Long id);

    @Override
    List<TypeMeasure> findAll();

    @Override
    TypeMeasure findById(Long id);

    List<TypeMeasure> findAllByClothesId(Long id);

}
