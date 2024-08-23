package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<CustomerDTO> getAll();

    CustomerDTO save(CustomerDTO customer);

    Optional<CustomerDTO> update(CustomerDTO customer, Long id);

    Optional<CustomerDTO> delete(Long id);

    Optional<CustomerDTO> findById(Long id);

}
