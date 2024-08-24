package com.orm.evaluacion2.controllers;

import com.orm.evaluacion2.dtos.OrderDTO;
import com.orm.evaluacion2.services.OrderServiceImplementation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Order")
public class OrderController {

    @Autowired
    private OrderServiceImplementation orderService;

    @Operation(summary = "Get all orders", description = "Get all orders from the database")
    @ApiResponse(responseCode = "200", description = "Orders found")
    @ApiResponse(responseCode = "204", description = "No content")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/getAll")
    ResponseEntity<?> getAll() {
        try {
            List<OrderDTO> orders = orderService.getAll();
            if (orders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred while getting the orders in controller: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Operation(summary = "Save an order", description = "Save an order in the database")
    @ApiResponse(responseCode = "201", description = "Order saved")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PostMapping("/save")
    ResponseEntity<?> save(@Validated @RequestBody OrderDTO order) {
        try {
            OrderDTO newOrder = orderService.save(order);
            return new ResponseEntity<>(newOrder, HttpStatus.CREATED);

        } catch (Exception ex) {
            System.out.println("An error occurred while saving the order in controller: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update an order", description = "Update an order in the database")
    @ApiResponse(responseCode = "200", description = "Order updated")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@Validated @RequestBody OrderDTO order, @PathVariable Long id) {
        try {
            Optional<OrderDTO> orderUpdated = orderService.update(order, id);

            return new ResponseEntity<>(orderUpdated, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred while updating the order in controller: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Operation(summary = "Delete an order", description = "Delete an order in the database")
    @ApiResponse(responseCode = "200", description = "Order deleted")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            Optional<OrderDTO> orderDeleted = orderService.delete(id);

            return new ResponseEntity<>(orderDeleted, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred while deleting the order in controller: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get an order by id", description = "Get an order by id from the database")
    @ApiResponse(responseCode = "200", description = "Order found")
    @ApiResponse(responseCode = "404", description = "Order not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/findById/{id}")
    ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Optional<OrderDTO> order = orderService.findById(id);

            return new ResponseEntity<>(order, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred while getting the order by id in controller: " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
