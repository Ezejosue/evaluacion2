package com.orm.evaluacion2.controllers;

import com.orm.evaluacion2.dtos.ProductDTO;
import com.orm.evaluacion2.services.ProductServiceImplementation;
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
@RequestMapping("/api/products")
@Tag(name = "Product")
public class ProductController {

    @Autowired
    private ProductServiceImplementation productService;

    @Operation(summary = "Get all products", description = "Get all products from the database")
    @ApiResponse(responseCode = "200", description = "Products found")
    @ApiResponse(responseCode = "204", description = "No content")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/getAll")
    ResponseEntity<?> getAll() {
        try {
            List<ProductDTO> products = productService.getAll();
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);


        } catch (Exception ex) {
            System.out.println("An error occurred in getAll method of product controller: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Save a product", description = "Save a product in the database")
    @ApiResponse(responseCode = "201", description = "Product saved")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PostMapping("/save")
    ResponseEntity<?> save(@Validated @RequestBody ProductDTO product) {
        try {
            ProductDTO newProduct = productService.save(product);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);

        } catch (Exception ex) {
            System.out.println("An error occurred in save method of product controller: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update a product", description = "Update a product in the database")
    @ApiResponse(responseCode = "200", description = "Product updated")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@Validated @RequestBody ProductDTO product, @PathVariable Long id) {
        try {
            ProductDTO updatedProduct = productService.update(product, id).orElse(null);
            if (updatedProduct == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in update method of product controller: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Delete a product", description = "Delete a product from the database")
    @ApiResponse(responseCode = "200", description = "Product deleted")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            ProductDTO deletedProduct = productService.delete(id).orElse(null);
            if (deletedProduct == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(deletedProduct, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in delete method of product controller: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Find a product by id", description = "Find a product by id in the database")
    @ApiResponse(responseCode = "200", description = "Product found")
    @ApiResponse(responseCode = "404", description = "Product not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/findById/{id}")
    ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            ProductDTO product = productService.findById(id).orElse(null);
            if (product == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(product, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in findById method of product controller: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
