package com.josespx.confections.service;


import com.josespx.confections.dao.Dao;
import com.josespx.confections.model.Measure;

import java.util.List;

public interface MeasureService extends Dao<Measure, Long> {

    @Override
    void save(Measure measure);

    @Override
    void deleteById(Long id);

    @Override
    List<Measure> findAll();

    @Override
    Measure findById(Long id);

    List<Measure> findAllByClientId(Long id);

    List<Measure> findAllByClientIdAndTypeMeasureClothesId(Long idClient, Long idTypeMeasure, String e1, String e2);
}
