package com.orm.evaluacion2.repositories;

import com.orm.evaluacion2.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {
}
