package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<OrderDTO> getAll();

    OrderDTO save(OrderDTO order);

    Optional<OrderDTO> update(OrderDTO order, Long id);

    Optional<OrderDTO> delete(Long id);

    Optional<OrderDTO> findById(Long id);
}
