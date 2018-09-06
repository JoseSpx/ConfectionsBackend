package com.josespx.confections.service;

import com.josespx.confections.dao.TypeMeasureDao;
import com.josespx.confections.model.TypeMeasure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TypeMeasureServiceImpl implements TypeMeasureService {

    private TypeMeasureDao typeMeasureDao;

    public TypeMeasureServiceImpl(TypeMeasureDao typeMeasureDao) {
        this.typeMeasureDao = typeMeasureDao;
    }

    @Override
    public void save(TypeMeasure typeMeasure) {
        this.typeMeasureDao.save(typeMeasure);
    }

    @Override
    public void deleteById(Long id) {
        this.typeMeasureDao.deleteById(id);
    }

    @Override
    public List<TypeMeasure> findAll() {
        return this.typeMeasureDao.findAll();
    }

    @Override
    public TypeMeasure findById(Long id) {
        return this.typeMeasureDao.findById(id).orElse(null);
    }

    @Override
    public List<TypeMeasure> findAllByClothesId(Long id) {
        return this.typeMeasureDao.findAllByClothes_Id(id);
    }


}
