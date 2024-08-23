package com.orm.evaluacion2.repositories;

import com.orm.evaluacion2.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepository extends CrudRepository<Order, Long> {
}
