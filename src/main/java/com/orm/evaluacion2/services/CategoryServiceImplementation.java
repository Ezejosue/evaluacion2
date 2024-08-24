package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.CategoryDTO;
import com.orm.evaluacion2.entities.Category;
import com.orm.evaluacion2.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAll() {
        try {
            List<Category> categories = (List<Category>) categoryRepository.findAll();

            if (categories.isEmpty()) {
                System.out.println("No categories found");
            }

            return categories.stream()
                    .map(category -> new CategoryDTO(
                            category.getCategoryId(),
                            category.getCategoryName(),
                            category.getCategoryType()
                    ))
                    .collect(Collectors.toList());

        } catch (Exception ex) {
            System.out.println("An error occurred in getAll method of category service: " + ex.getMessage());
            return List.of();
        }
    }

    @Override
    public CategoryDTO save(CategoryDTO category) {
        try {
            Category newCategory = new Category();
            newCategory.setCategoryName(category.getCategoryName());
            newCategory.setCategoryType(category.getCategoryType());

            return new CategoryDTO(
                    categoryRepository.save(newCategory).getCategoryId(),
                    category.getCategoryName(),
                    category.getCategoryType()
            );

        } catch (Exception ex) {
            System.out.println("An error occurred in save method of category service: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Optional<CategoryDTO> update(CategoryDTO category, Long id) {
        try {
            Optional<Category> categoryData = categoryRepository.findById(id);

            if (categoryData.isPresent()) {
                Category updatedCategory = categoryData.get();
                updatedCategory.setCategoryName(category.getCategoryName());
                updatedCategory.setCategoryType(category.getCategoryType());

                return Optional.of(new CategoryDTO(
                        categoryRepository.save(updatedCategory).getCategoryId(),
                        category.getCategoryName(),
                        category.getCategoryType()
                ));
            }

            return Optional.empty();

        } catch (Exception ex) {
            System.out.println("An error occurred in update method of category service: " + ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryDTO> delete(Long id) {
        try {
            Optional<Category> categoryData = categoryRepository.findById(id);

            if (categoryData.isPresent()) {
                categoryRepository.deleteById(id);
                return Optional.of(new CategoryDTO(
                        categoryData.get().getCategoryId(),
                        categoryData.get().getCategoryName(),
                        categoryData.get().getCategoryType()
                ));
            }

            return Optional.empty();

        } catch (Exception ex) {
            System.out.println("An error occurred in delete method of category service: " + ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CategoryDTO> findById(Long id) {
        try {
            Optional<Category> categoryData = categoryRepository.findById(id);

            if (categoryData.isPresent()) {
                return Optional.of(new CategoryDTO(
                        categoryData.get().getCategoryId(),
                        categoryData.get().getCategoryName(),
                        categoryData.get().getCategoryType()
                ));
            }

            return Optional.empty();

        } catch (Exception ex) {
            System.out.println("An error occurred in findById method of category service: " + ex.getMessage());
            return Optional.empty();
        }
    }
}
