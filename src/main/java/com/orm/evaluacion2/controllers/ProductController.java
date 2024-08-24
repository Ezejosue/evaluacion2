package com.orm.evaluacion2.controllers;

import com.orm.evaluacion2.dtos.ProductDTO;
import com.orm.evaluacion2.services.ProductServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImplementation productService;

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
