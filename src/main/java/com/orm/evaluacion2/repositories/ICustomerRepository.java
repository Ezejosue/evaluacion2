package com.orm.evaluacion2.repositories;

import com.orm.evaluacion2.entities.Customer;
import org.springframework.data.repository.CrudRepository;


public interface ICustomerRepository extends CrudRepository<Customer, Long> {

}
