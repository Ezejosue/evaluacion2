package com.orm.evaluacion2.controllers;

import com.orm.evaluacion2.dtos.CustomerDTO;
import com.orm.evaluacion2.services.CustomerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImplementation customerService;

    @RequestMapping("/getAll")
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
