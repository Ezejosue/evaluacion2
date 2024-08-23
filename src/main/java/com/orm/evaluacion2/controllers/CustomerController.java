package com.orm.evaluacion2.controllers;

import com.orm.evaluacion2.dtos.CustomerDTO;
import com.orm.evaluacion2.entities.Customer;
import com.orm.evaluacion2.services.CustomerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
}
