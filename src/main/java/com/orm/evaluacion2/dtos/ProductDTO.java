package com.orm.evaluacion2.dtos;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private Long productId;
    private String productName;
    private Double price;
    private Long categoryId;
    private String categoryName;

    public ProductDTO() {
    }

    public ProductDTO(Long productId, String productName, Double price, Long categoryId, String categoryName) {
        this();
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }


    public ProductDTO(Long productId, String productName, Double price) {
        this();
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
