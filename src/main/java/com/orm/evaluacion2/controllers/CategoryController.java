package com.orm.evaluacion2.controllers;

import com.orm.evaluacion2.dtos.CategoryDTO;
import com.orm.evaluacion2.services.CategoryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImplementation categoryService;

    @GetMapping("/getAll")
    ResponseEntity<?> getAll() {
        try {
            List<CategoryDTO> categories = categoryService.getAll();
            if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in getAll Method of CategoryController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    ResponseEntity<?> save(@Validated @RequestBody CategoryDTO category) {
        try {
            CategoryDTO newCategory = categoryService.save(category);
            return new ResponseEntity<>(newCategory, HttpStatus.CREATED);

        } catch (Exception ex) {
            System.out.println("An error occurred in save Method of CategoryController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@Validated @RequestBody CategoryDTO category, @PathVariable Long id) {
        try {
            CategoryDTO updatedCategory = categoryService.update(category, id).orElse(null);
            if (updatedCategory == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in update Method of CategoryController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            CategoryDTO deletedCategory = categoryService.delete(id).orElse(null);
            if (deletedCategory == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(deletedCategory, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in delete Method of CategoryController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            CategoryDTO category = categoryService.findById(id).orElse(null);
            if (category == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(category, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in findById Method of CategoryController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
