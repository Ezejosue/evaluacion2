package com.orm.evaluacion2.dtos;

public class ProductDTO {
    private Long productId;
    private String productName;
    private Long categoryId;
    private String categoryName;

    public ProductDTO() {
    }

    public ProductDTO(Long productId, String productName, Long categoryId, String categoryName) {
        this();
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public ProductDTO(Long productId, String productName, Long categoryId) {
        this();
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
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

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
