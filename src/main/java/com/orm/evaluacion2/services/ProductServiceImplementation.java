package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.CategoryDTO;
import com.orm.evaluacion2.dtos.ProductDTO;
import com.orm.evaluacion2.entities.Category;
import com.orm.evaluacion2.entities.Product;
import com.orm.evaluacion2.repositories.ICategoryRepository;
import com.orm.evaluacion2.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public List<ProductDTO> getAll() {
        try {

            List<Product> products = (List<Product>) productRepository.findAll();

            if (products.isEmpty()) {
                System.out.println("No products found");
            }

            return products.stream()
                    .map(product -> {
                        Long categoryId = product.getCategory().getCategoryId();
                        String categoryName = product.getCategory().getCategoryName();
                        return new ProductDTO(
                                product.getProductId(),
                                product.getProductName(),
                                product.getPrice(),
                                categoryId,
                                categoryName
                        );
                    })
                    .collect(Collectors.toList());

        } catch (Exception ex) {
            System.out.println("An error occurred in getAll method of product service: " + ex.getMessage());
            return List.of();
        }
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        try {
            Optional<Category> categoryOptional = categoryRepository.findById(product.getCategoryId());

            if (categoryOptional.isEmpty()) {
                System.out.println("Category not found");
                return null;
            }

            Category category = categoryOptional.get();

            Product newProduct = new Product();
            newProduct.setProductName(product.getProductName());
            newProduct.setCategory(category);

            Product savedProduct = productRepository.save(newProduct);

            return new ProductDTO(
                    savedProduct.getProductId(),
                    savedProduct.getProductName(),
                    savedProduct.getPrice(),
                    savedProduct.getCategory().getCategoryId(),
                    savedProduct.getCategory().getCategoryName()
            );

        } catch (Exception ex) {
            System.out.println("An error occurred in save method of product service: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Optional<ProductDTO> update(ProductDTO product, Long id) {
        try {
            Optional<Product> productOptional = productRepository.findById(id);

            if (productOptional.isEmpty()) {
                System.out.println("Product not found");
                return Optional.empty();
            }

            Optional<Category> categoryOptional = categoryRepository.findById(product.getCategoryId());

            if (categoryOptional.isEmpty()) {
                System.out.println("Category not found");
                return Optional.empty();
            }

            Product productEntity = productOptional.get();
            productEntity.setProductName(product.getProductName());
            productEntity.setCategory(categoryOptional.get());
            productEntity.setPrice(product.getPrice());

            Product updatedProduct = productRepository.save(productEntity);

            return Optional.of(new ProductDTO(
                    updatedProduct.getProductId(),
                    updatedProduct.getProductName(),
                    updatedProduct.getPrice(),
                    updatedProduct.getCategory().getCategoryId(),
                    updatedProduct.getCategory().getCategoryName()
            ));


        } catch (
                Exception ex) {
            System.out.println("An error occurred in update method of product service: " + ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductDTO> delete(Long id) {
        try {
            Optional<Product> productOptional = productRepository.findById(id);

            if (productOptional.isEmpty()) {
                System.out.println("Product not found");
                return Optional.empty();
            }

            Product product = productOptional.get();
            productRepository.delete(product);

            return Optional.of(new ProductDTO(
                    product.getProductId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getCategory().getCategoryId(),
                    product.getCategory().getCategoryName()
            ));

        } catch (Exception ex) {
            System.out.println("An error occurred in delete method of product service: " + ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        try {
            Optional<Product> productOptional = productRepository.findById(id);

            if (productOptional.isEmpty()) {
                System.out.println("Product not found");
                return Optional.empty();
            }

            Product product = productOptional.get();

            return Optional.of(new ProductDTO(
                    product.getProductId(),
                    product.getProductName(),
                    product.getPrice(),
                    product.getCategory().getCategoryId(),
                    product.getCategory().getCategoryName()
            ));

        } catch (Exception ex) {
            System.out.println("An error occurred in findById method of product service: " + ex.getMessage());
            return Optional.empty();
        }
    }
}
