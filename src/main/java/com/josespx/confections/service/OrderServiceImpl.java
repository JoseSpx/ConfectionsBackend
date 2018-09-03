package com.josespx.confections.service;

import com.josespx.confections.dao.OrderDao;
import com.josespx.confections.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void save(Order order) {
        this.orderDao.save(order);
    }

    @Override
    public void deleteById(Long id) {
        this.orderDao.deleteById(id);
    }

    @Override
    public List<Order> findAll() {
        return this.orderDao.findAll();
    }

    @Override
    public Order findById(Long id) {
        return this.orderDao.findById(id).orElse(null);
    }

    @Override
    public List<Order> findAllByClientId(Long id) {
        return this.orderDao.findAllByClientId(id);
    }
}
