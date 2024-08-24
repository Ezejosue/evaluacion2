package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<CategoryDTO> getAll();

    CategoryDTO save(CategoryDTO category);

    Optional<CategoryDTO> update(CategoryDTO category, Long id);

    Optional<CategoryDTO> delete(Long id);

    Optional<CategoryDTO> findById(Long id);
}
