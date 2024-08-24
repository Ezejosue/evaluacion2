package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.DeliveryDTO;

import java.util.List;
import java.util.Optional;

public interface IDeliveryService {
    List<DeliveryDTO> getAll();

    DeliveryDTO save(DeliveryDTO delivery);

    Optional<DeliveryDTO> update(DeliveryDTO delivery, Long id);

    Optional<DeliveryDTO> delete(Long id);

    Optional<DeliveryDTO> findById(Long id);
}
