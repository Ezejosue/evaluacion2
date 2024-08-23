package com.orm.evaluacion2.services;

import com.orm.evaluacion2.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> getAll();

    Product save(Product product);

    Optional<Product> update(Product product, Long id);

    Optional<Product> delete(Long id);

    Optional<Product> findById(Long id);
}
