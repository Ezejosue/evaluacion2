package com.orm.evaluacion2.dtos;

import com.orm.evaluacion2.entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderDTO {
    private Long orderId;
    private LocalDate orderDate;
    private Long customerId;
    private Long deliveryId;
    private List<ProductDTO> products;

    public OrderDTO() {
        this.products = new ArrayList<>();
    }

    public OrderDTO(Long orderId, LocalDate orderDate, Long customerId, Long deliveryId, List<ProductDTO> products) {
        this();
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.deliveryId = deliveryId;
        this.products = products;
    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", orderDate='" + orderDate + '\'' +
                ", customerId=" + customerId +
                ", deliveryId=" + deliveryId +
                ", products=" + products +
                '}';
    }
}


