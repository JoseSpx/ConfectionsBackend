package com.josespx.confections.dao;

import com.josespx.confections.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {

    List<Order> findAllByClientId(Long id);
    List<Order> findAllByOrderByDateDealDesc();
}
