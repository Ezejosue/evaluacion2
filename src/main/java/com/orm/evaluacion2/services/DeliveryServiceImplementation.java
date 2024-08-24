package com.orm.evaluacion2.services;

import com.orm.evaluacion2.dtos.DeliveryDTO;
import com.orm.evaluacion2.entities.Delivery;
import com.orm.evaluacion2.repositories.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImplementation implements IDeliveryService {

    @Autowired
    private IDeliveryRepository deliveryRepository;


    @Override
    public List<DeliveryDTO> getAll() {
        try {
            List<Delivery> deliveries = (List<Delivery>) deliveryRepository.findAll();

            if (deliveries.isEmpty()) {
                System.out.println("No deliveries found");
            }

            return deliveries.stream()
                    .map(delivery -> new DeliveryDTO(
                            delivery.getDeliveryId(),
                            delivery.getType(),
                            delivery.getStatus()
                    ))
                    .collect(Collectors.toList());

        } catch (Exception ex) {
            System.out.println("An error occurred in getAll method of delivery service: " + ex.getMessage());
            return List.of();
        }
    }

    @Override
    public DeliveryDTO save(DeliveryDTO delivery) {
        try {
            Delivery newDelivery = new Delivery();
            newDelivery.setType(delivery.getType());
            newDelivery.setStatus(delivery.getStatus());

            return new DeliveryDTO(
                    deliveryRepository.save(newDelivery).getDeliveryId(),
                    delivery.getType(),
                    delivery.getStatus()
            );

        } catch (Exception ex) {
            System.out.println("An error occurred in save method of delivery service: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Optional<DeliveryDTO> update(DeliveryDTO delivery, Long id) {
        try {
            Optional<Delivery> deliveryData = deliveryRepository.findById(id);

            if (deliveryData.isPresent()) {
                Delivery updatedDelivery = deliveryData.get();
                updatedDelivery.setType(delivery.getType());
                updatedDelivery.setStatus(delivery.getStatus());

                return Optional.of(new DeliveryDTO(
                        deliveryRepository.save(updatedDelivery).getDeliveryId(),
                        delivery.getType(),
                        delivery.getStatus()
                ));
            }

            return Optional.empty();

        } catch (Exception ex) {
            System.out.println("An error occurred in update method of delivery service: " + ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<DeliveryDTO> delete(Long id) {
        try {
            Optional<Delivery> deliveryData = deliveryRepository.findById(id);

            if (deliveryData.isPresent()) {
                deliveryRepository.deleteById(id);
                return Optional.of(new DeliveryDTO(
                        deliveryData.get().getDeliveryId(),
                        deliveryData.get().getType(),
                        deliveryData.get().getStatus()
                ));
            }

            return Optional.empty();

        } catch (Exception ex) {
            System.out.println("An error occurred in delete method of delivery service: " + ex.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<DeliveryDTO> findById(Long id) {
        try {
            Optional<Delivery> deliveryData = deliveryRepository.findById(id);

            if (deliveryData.isPresent()) {
                return Optional.of(new DeliveryDTO(
                        deliveryData.get().getDeliveryId(),
                        deliveryData.get().getType(),
                        deliveryData.get().getStatus()
                ));
            }

            return Optional.empty();

        } catch (Exception ex) {
            System.out.println("An error occurred in findById method of delivery service: " + ex.getMessage());
            return Optional.empty();
        }
    }
}
