package com.orm.evaluacion2.dtos;

public class DeliveryDTO {
    private Long deliveryId;
    private String type;
    private String status;

    public DeliveryDTO() {
    }

    public DeliveryDTO(Long deliveryId, String type, String status) {
        this.deliveryId = deliveryId;
        this.type = type;
        this.status = status;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "deliveryId=" + deliveryId +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
