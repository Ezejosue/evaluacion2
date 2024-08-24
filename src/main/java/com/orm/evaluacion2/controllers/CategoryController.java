package com.orm.evaluacion2.controllers;

import com.orm.evaluacion2.dtos.CategoryDTO;
import com.orm.evaluacion2.services.CategoryServiceImplementation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category")
public class CategoryController {

    @Autowired
    private CategoryServiceImplementation categoryService;

    @Operation(summary = "Get all categories", description = "Get all categories from the database")
    @ApiResponse(responseCode = "200", description = "Categories found")
    @ApiResponse(responseCode = "204", description = "No content")
    @ApiResponse(responseCode = "500", description = "Internal server error")
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

    @Operation(summary = "Save a category", description = "Save a category in the database")
    @ApiResponse(responseCode = "201", description = "Category saved")
    @ApiResponse(responseCode = "500", description = "Internal server error")
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

    @Operation(summary = "Update a category", description = "Update a category in the database")
    @ApiResponse(responseCode = "200", description = "Category updated")
    @ApiResponse(responseCode = "404", description = "Category not found")
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

    @Operation(summary = "Delete a category", description = "Delete a category in the database")
    @ApiResponse(responseCode = "200", description = "Category deleted")
    @ApiResponse(responseCode = "404", description = "Category not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
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

    @Operation(summary = "Find a category by id", description = "Find a category by id in the database")
    @ApiResponse(responseCode = "200", description = "Category found")
    @ApiResponse(responseCode = "404", description = "Category not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
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
