package com.orm.evaluacion2.services;

import com.orm.evaluacion2.entities.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> getAll();

    Order save(Order order);

    Optional<Order> update(Order order, Long id);

    Optional<Order> delete(Long id);

    Optional<Order> findById(Long id);
}
