package com.orm.evaluacion2.services;

import com.orm.evaluacion2.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> getAll();

    Customer save(Customer customer);

    Optional<Customer> update(Customer customer, Long id);

    Optional<Customer> delete(Long id);

    Optional<Customer> findById(Long id);
}
