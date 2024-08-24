package com.orm.evaluacion2.controllers;

import com.orm.evaluacion2.dtos.DeliveryDTO;
import com.orm.evaluacion2.services.DeliveryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryServiceImplementation deliveryService;

    @GetMapping("/getAll")
    ResponseEntity<?> getAll() {
        try {
            List<DeliveryDTO> deliveries = deliveryService.getAll();
            if (deliveries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(deliveries, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in getAll Method of DeliveryController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    ResponseEntity<?> save(@Validated @RequestBody DeliveryDTO delivery) {
        try {
            DeliveryDTO newDelivery = deliveryService.save(delivery);
            return new ResponseEntity<>(newDelivery, HttpStatus.CREATED);

        } catch (Exception ex) {
            System.out.println("An error occurred in save Method of DeliveryController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> update(@Validated @RequestBody DeliveryDTO delivery, @PathVariable Long id) {
        try {
            DeliveryDTO updatedDelivery = deliveryService.update(delivery, id).orElse(null);
            if (updatedDelivery == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedDelivery, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in update Method of DeliveryController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            DeliveryDTO deletedDelivery = deliveryService.delete(id).orElse(null);
            if (deletedDelivery == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(deletedDelivery, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in delete Method of DeliveryController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            DeliveryDTO delivery = deliveryService.findById(id).orElse(null);
            if (delivery == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(delivery, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("An error occurred in findById Method of DeliveryController: " + ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
