package com.orm.evaluacion2.repositories;

import com.orm.evaluacion2.dtos.ProductDTO;
import com.orm.evaluacion2.entities.Order;
import com.orm.evaluacion2.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IOrderRepository extends CrudRepository<Order, Long> {

    @Query("SELECT o FROM Order o JOIN FETCH o.products")
    List<Order> findAllOrdersWithProducts();

    @Query("SELECT o FROM Order o JOIN FETCH o.products WHERE o.orderId = :orderId")
    Optional<Order> findOrderByIdWithProducts(@Param("orderId") Long orderId);
}
