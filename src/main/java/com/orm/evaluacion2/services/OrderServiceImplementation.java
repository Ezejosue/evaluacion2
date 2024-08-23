package com.orm.evaluacion2.services;

import com.orm.evaluacion2.entities.Order;
import com.orm.evaluacion2.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return List.of();
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Optional<Order> update(Order order, Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }
}
