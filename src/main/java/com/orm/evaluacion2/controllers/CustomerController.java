package com.orm.evaluacion2.controllers;

import com.orm.evaluacion2.dtos.CustomerDTO;
import com.orm.evaluacion2.services.CustomerServiceImplementation;
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
@RequestMapping("/api/customers")
@Tag(name = "Customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImplementation customerService;

    @Operation(summary = "Get all customers", description = "Get all customers from the database")
    @ApiResponse(responseCode = "200", description = "Customers found")
    @ApiResponse(responseCode = "204", description = "No content")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/getAll")
    ResponseEntity<?> getAll() {
        try {
            List<CustomerDTO> customers = customerService.getAll();
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in getAll Method of CustomerController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Save a customer", description = "Save a customer in the database")
    @ApiResponse(responseCode = "201", description = "Customer saved")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PostMapping("/save")
    ResponseEntity<?> save(@Validated @RequestBody CustomerDTO customer) {
        try {
            CustomerDTO newCustomer = customerService.save(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);

        } catch (Exception ex) {
            System.out.println("An error occurred in save Method of CustomerController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Update a customer", description = "Update a customer in the database")
    @ApiResponse(responseCode = "200", description = "Customer updated")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@Validated @RequestBody CustomerDTO customer, @PathVariable Long id) {
        try {
            CustomerDTO updatedCustomer = customerService.update(customer, id).orElse(null);
            if (updatedCustomer == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in update Method of CustomerController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Delete a customer", description = "Delete a customer from the database")
    @ApiResponse(responseCode = "200", description = "Customer deleted")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            CustomerDTO deletedCustomer = customerService.delete(id).orElse(null);
            if (deletedCustomer == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in delete Method of CustomerController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Find a customer by ID", description = "Find a customer by ID in the database")
    @ApiResponse(responseCode = "200", description = "Customer found")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/findById/{id}")
    ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            CustomerDTO customer = customerService.findById(id).orElse(null);
            if (customer == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in findById Method of CustomerController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
