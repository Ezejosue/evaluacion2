package com.orm.evaluacion2.controllers;

import com.orm.evaluacion2.dtos.DeliveryDTO;
import com.orm.evaluacion2.services.DeliveryServiceImplementation;
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
@RequestMapping("/api/deliveries")
@Tag(name = "Delivery")
public class DeliveryController {

    @Autowired
    private DeliveryServiceImplementation deliveryService;

    @Operation(summary = "Get all deliveries", description = "Get all deliveries")
    @ApiResponse(responseCode = "200", description = "Get all deliveries")
    @ApiResponse(responseCode = "204", description = "No content")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
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

    @Operation(summary = "Save a delivery", description = "Save a delivery")
    @ApiResponse(responseCode = "201", description = "Delivery saved")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
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

    @Operation(summary = "Update a delivery", description = "Update a delivery")
    @ApiResponse(responseCode = "200", description = "Delivery updated")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
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

    @Operation(summary = "Delete a delivery", description = "Delete a delivery")
    @ApiResponse(responseCode = "200", description = "Delivery deleted")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
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

    @Operation(summary = "Find a delivery by id", description = "Find a delivery by id")
    @ApiResponse(responseCode = "200", description = "Delivery found")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
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
