package com.orm.evaluacion2.services;

import com.orm.evaluacion2.entities.Customer;
import com.orm.evaluacion2.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return List.of();
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Optional<Customer> update(Customer customer, Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }
}
