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
        try {
            Customer newCustomer = new Customer();
            newCustomer.setCustomerName(customer.getCustomerName());
            newCustomer.setCustomerEmail(customer.getCustomerEmail());
            newCustomer.setCustomerAddress(customer.getCustomerAddress());

            return new CustomerDTO(
                    customerRepository.save(newCustomer).getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerEmail(),
                    customer.getCustomerAddress()
            );

        } catch (Exception ex) {
            System.out.println("An error occurred in save Method of CustomerServiceImplementation: " + ex);
            return null;
        }
    }

    @Override
    public Optional<CustomerDTO> update(CustomerDTO customer, Long id) {
        try {
            Optional<Customer> customerData = customerRepository.findById(id);

            if (customerData.isPresent()) {
                Customer updatedCustomer = customerData.get();
                updatedCustomer.setCustomerName(customer.getCustomerName());
                updatedCustomer.setCustomerEmail(customer.getCustomerEmail());
                updatedCustomer.setCustomerAddress(customer.getCustomerAddress());

                return Optional.of(new CustomerDTO(
                        customerRepository.save(updatedCustomer).getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerEmail(),
                        customer.getCustomerAddress()
                ));
            }

            return Optional.empty();

        } catch (Exception ex) {
            System.out.println("An error occurred in update Method of CustomerServiceImplementation: " + ex);
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerDTO> delete(Long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);

            if (customer.isPresent()) {
                customerRepository.deleteById(id);
                return Optional.of(new CustomerDTO(
                        customer.get().getCustomerId(),
                        customer.get().getCustomerName(),
                        customer.get().getCustomerEmail(),
                        customer.get().getCustomerAddress()
                ));
            }

            return Optional.empty();

        } catch (Exception ex) {
            System.out.println("An error occurred in delete Method of CustomerServiceImplementation: " + ex);
            return Optional.empty();
        }
    }

    @Override
    public Optional<CustomerDTO> findById(Long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);

            if (customer.isPresent()) {
                return Optional.of(new CustomerDTO(
                        customer.get().getCustomerId(),
                        customer.get().getCustomerName(),
                        customer.get().getCustomerEmail(),
                        customer.get().getCustomerAddress()
                ));
            }

            return Optional.empty();

        } catch (Exception ex) {
            System.out.println("An error occurred in findById Method of CustomerServiceImplementation: " + ex);
            return Optional.empty();
        }
    }
}
