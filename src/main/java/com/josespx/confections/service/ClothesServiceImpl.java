package com.josespx.confections.service;

import com.josespx.confections.dao.ClothesDao;
import com.josespx.confections.model.Clothes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("clothesService")
@Transactional
public class ClothesServiceImpl implements ClothesService {

    private ClothesDao clothesDao;

    @Autowired
    public ClothesServiceImpl(ClothesDao clothesDao) {
        this.clothesDao = clothesDao;
    }

    @Override
    public void save(Clothes clothes) {
        this.clothesDao.save(clothes);
    }

    @Override
    public void deleteById(Long id) {
        this.clothesDao.deleteById(id);
    }

    @Override
    public List<Clothes> findAll() {
        return this.clothesDao.findAllByEliminatedEquals("0");
        // return this.clothesDao.findAll();
    }

    @Override
    public Clothes findById(Long id) {
        return this.clothesDao.findById(id).orElse(null);
    }
}
