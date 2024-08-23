package com.orm.evaluacion2.services;

import com.orm.evaluacion2.entities.Category;
import com.orm.evaluacion2.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return List.of();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public Optional<Category> update(Category category, Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }
}
