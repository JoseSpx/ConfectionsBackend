package com.josespx.confections.dao;

import java.util.List;

public interface Dao<Object, Key> {

    void save(Object object);
    void deleteById(Key key);
    List<Object> findAll();
    Object findById(Key key);

}
