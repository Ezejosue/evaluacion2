package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.OrderDTO;
import com.orm.evaluacion2.dtos.ProductDTO;
import com.orm.evaluacion2.entities.Customer;
import com.orm.evaluacion2.entities.Delivery;
import com.orm.evaluacion2.entities.Order;
import com.orm.evaluacion2.repositories.IOrderRepository;
import com.orm.evaluacion2.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImplementation implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<OrderDTO> getAll() {
        try {
            List<Order> orders = (List<Order>) orderRepository.findAllOrdersWithProducts();

            if (orders.isEmpty()) {
                System.out.println("No orders found");
            }

            return orders.stream()
                    .map(order -> new OrderDTO(
                            order.getOrderId(),
                            order.getOrderDate(),
                            order.getCustomer().getCustomerId(),
                            order.getDelivery().getDeliveryId(),
                            order.getProducts().stream()
                                    .map(product -> new ProductDTO(product.getProductId(), product.getProductName()))
                                    .collect(Collectors.toList())
                    ))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println("An error occurred while getting the orders in service implementation: " + e.getMessage());
            return List.of();
        }
    }

    @Override
    public OrderDTO save(OrderDTO order) {
        try {

            Customer customer = new Customer();
            customer.setCustomerId(order.getCustomerId());

            Delivery delivery = new Delivery();
            delivery.setDeliveryId(order.getDeliveryId());

            Order newOrder = new Order();
            newOrder.setOrderDate(order.getOrderDate());
            newOrder.setCustomer(customer);
            newOrder.setDelivery(delivery);
            newOrder.setProducts(order.getProducts().stream()
                    .map(product -> productRepository.findById(product.getProductId()).orElse(null))
                    .collect(Collectors.toList())
            );

            Order savedOrder = orderRepository.save(newOrder);

            return new OrderDTO(
                    savedOrder.getOrderId(),
                    savedOrder.getOrderDate(),
                    savedOrder.getCustomer().getCustomerId(),
                    savedOrder.getDelivery().getDeliveryId(),
                    savedOrder.getProducts().stream()
                            .map(product -> new ProductDTO(product.getProductId(), product.getProductName()))
                            .collect(Collectors.toList())
            );

        } catch (Exception ex) {
            System.out.println("An error occurred in save method of order service: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Optional<OrderDTO> update(OrderDTO order, Long id) {
        try {
            Optional<Order> orderToUpdate = orderRepository.findOrderByIdWithProducts(id);

            if (orderToUpdate.isEmpty()) {
                System.out.println("Order not found");
                return Optional.empty();
            }

            Customer customer = new Customer();
            customer.setCustomerId(order.getCustomerId());

            Delivery delivery = new Delivery();
            delivery.setDeliveryId(order.getDeliveryId());

            Order newOrder = new Order();
            newOrder.setOrderId(id);
            newOrder.setOrderDate(order.getOrderDate());
            newOrder.setCustomer(customer);
            newOrder.setDelivery(delivery);
            newOrder.setProducts(order.getProducts().stream()
                    .map(product -> productRepository.findById(product.getProductId()).orElse(null))
                    .collect(Collectors.toList())
            );

            Order updatedOrder = orderRepository.save(newOrder);

            return Optional.of(new OrderDTO(
                    updatedOrder.getOrderId(),
                    updatedOrder.getOrderDate(),
                    updatedOrder.getCustomer().getCustomerId(),
                    updatedOrder.getDelivery().getDeliveryId(),
                    updatedOrder.getProducts().stream()
                            .map(product -> new ProductDTO(product.getProductId(), product.getProductName()))
                            .collect(Collectors.toList())
            ));

        } catch (Exception ex) {
            System.out.println("An error occurred in update method of order service: " + ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<OrderDTO> delete(Long id) {
        try {
            Optional<Order> order = orderRepository.findOrderByIdWithProducts(id);

            if (order.isEmpty()) {
                System.out.println("Order not found");
                return Optional.empty();
            }

            orderRepository.deleteById(id);

            return Optional.of(new OrderDTO(
                    order.get().getOrderId(),
                    order.get().getOrderDate(),
                    order.get().getCustomer().getCustomerId(),
                    order.get().getDelivery().getDeliveryId(),
                    order.get().getProducts().stream()
                            .map(product -> new ProductDTO(product.getProductId(), product.getProductName()))
                            .collect(Collectors.toList())
            ));
        } catch (Exception ex) {
            System.out.println("An error occurred in delete method of order service: " + ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<OrderDTO> findById(Long id) {
        try {
            Optional<Order> order = orderRepository.findOrderByIdWithProducts(id);

            if (order.isEmpty()) {
                System.out.println("Order not found");
                return Optional.empty();
            }

            return Optional.of(new OrderDTO(
                    order.get().getOrderId(),
                    order.get().getOrderDate(),
                    order.get().getCustomer().getCustomerId(),
                    order.get().getDelivery().getDeliveryId(),
                    order.get().getProducts().stream()
                            .map(product -> new ProductDTO(product.getProductId(), product.getProductName()))
                            .collect(Collectors.toList())
            ));
        } catch (Exception ex) {
            System.out.println("An error occurred in findById method of order service: " + ex.getMessage());
            return Optional.empty();
        }
    }
}
