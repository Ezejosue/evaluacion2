package com.orm.evaluacion2.services;

import com.orm.evaluacion2.entities.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> getAll();

    Category save(Category category);

    Optional<Category> update(Category category, Long id);

    Optional<Category> delete(Long id);

    Optional<Category> findById(Long id);
}
