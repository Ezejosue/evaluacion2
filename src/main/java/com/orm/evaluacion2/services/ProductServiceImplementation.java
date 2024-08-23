package com.orm.evaluacion2.services;

import com.orm.evaluacion2.entities.Product;
import com.orm.evaluacion2.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> update(Product product, Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }
}
