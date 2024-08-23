package com.orm.evaluacion2.services;

import com.orm.evaluacion2.entities.Delivery;

import java.util.List;
import java.util.Optional;

public interface IDeliveryService {
    List<Delivery> getAll();

    Delivery save(Delivery delivery);

    Optional<Delivery> update(Delivery delivery, Long id);

    Optional<Delivery> delete(Long id);

    Optional<Delivery> findById(Long id);
}
