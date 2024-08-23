package com.orm.evaluacion2.repositories;

import com.orm.evaluacion2.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
}
