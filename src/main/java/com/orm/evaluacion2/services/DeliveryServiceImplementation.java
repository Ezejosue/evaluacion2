package com.orm.evaluacion2.services;

import com.orm.evaluacion2.entities.Delivery;
import com.orm.evaluacion2.repositories.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImplementation implements IDeliveryService {

    @Autowired
    private IDeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> getAll() {
        return List.of();
    }

    @Override
    public Delivery save(Delivery delivery) {
        return null;
    }

    @Override
    public Optional<Delivery> update(Delivery delivery, Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Delivery> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Delivery> findById(Long id) {
        return Optional.empty();
    }
}
