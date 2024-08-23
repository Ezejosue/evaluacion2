package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.CustomerDTO;
import com.orm.evaluacion2.entities.Customer;
import com.orm.evaluacion2.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImplementation implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public List<CustomerDTO> getAll() {
        try {
            List<Customer> customers = (List<Customer>) customerRepository.findAll();

            if (customers.isEmpty()) {
                System.out.println("No customers found");
            }

            return customers.stream()
                    .map(customer -> new CustomerDTO(
                            customer.getCustomerId(),
                            customer.getCustomerName(),
                            customer.getCustomerEmail(),
                            customer.getCustomerAddress()
                    ))
                    .collect(Collectors.toList());

        } catch (Exception ex) {
            System.out.println("An error occurred in getAll Method of CustomerServiceImplementation: " + ex);
            return List.of();
        }
    }

    @Override
    public CustomerDTO save(CustomerDTO customer) {
        return null;
    }

    @Override
    public Optional<CustomerDTO> update(CustomerDTO customer, Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerDTO> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CustomerDTO> findById(Long id) {
        return Optional.empty();
    }
}
