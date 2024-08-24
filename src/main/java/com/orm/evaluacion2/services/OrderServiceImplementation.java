package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.OrderDTO;
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
    public List<OrderDTO> getAll() {
        return List.of();
    }

    @Override
    public OrderDTO save(OrderDTO order) {
        return null;
    }

    @Override
    public Optional<OrderDTO> update(OrderDTO order, Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<OrderDTO> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<OrderDTO> findById(Long id) {
        return Optional.empty();
    }
}
