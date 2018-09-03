package com.josespx.confections.service;

import com.josespx.confections.dao.Dao;
import com.josespx.confections.model.Order;

import java.util.List;

public interface OrderService extends Dao<Order, Long> {

    @Override
    void save(Order order);

    @Override
    void deleteById(Long id);

    @Override
    List<Order> findAll();

    @Override
    Order findById(Long id);

    List<Order> findAllByClientId(Long id);
}
