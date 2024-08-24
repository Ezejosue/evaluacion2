package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<ProductDTO> getAll();

    ProductDTO save(ProductDTO product);

    Optional<ProductDTO> update(ProductDTO product, Long id);

    Optional<ProductDTO> delete(Long id);

    Optional<ProductDTO> findById(Long id);
}
