package com.josespx.confections.service;

import com.josespx.confections.dao.MeasureDao;
import com.josespx.confections.model.Measure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "measureService")
public class MeasureServiceImpl implements MeasureService {

    private MeasureDao measureDao;

    @Autowired
    public MeasureServiceImpl(MeasureDao measureDao) {
        this.measureDao = measureDao;
    }


    @Override
    public void save(Measure measure) {
        this.measureDao.save(measure);
    }

    @Override
    public void deleteById(Long id) {
        this.measureDao.deleteById(id);
    }

    @Override
    public List<Measure> findAll() {
        return this.measureDao.findAll();
    }

    @Override
    public Measure findById(Long id) {
        return this.measureDao.findById(id).orElse(null);
    }

    @Override
    public List<Measure> findAllByClientId(Long id) {
        return this.measureDao.findAllByClientIdEquals(id);
    }

    @Override
    public List<Measure> findAllByClientIdAndTypeMeasureClothesId(Long idClient, Long idClothes, String e1, String e2) {
        //return this.measureDao.findAllByClientIdAndTypeMeasureClothes_IdAndTypeMeasureEliminatedAndTypeMeasureClothesEliminated
          //      (idClient, idClothes, e1, e2);
        return this.measureDao.findAllByClient_IdAndTypeMeasure_Clothes_IdAndTypeMeasure_EliminatedAndTypeMeasure_Clothes_Eliminated
                (idClient, idClothes, e1, e2);
    }
}
