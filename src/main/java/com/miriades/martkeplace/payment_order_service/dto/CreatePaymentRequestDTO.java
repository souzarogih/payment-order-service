package com.miriades.martkeplace.payment_order_service.dto;

import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class CreatePaymentRequestDTO {
    private String correlationId;
    private String data;

    public CreatePaymentRequestDTO(String correlationId, String data) {
        this.correlationId = correlationId;
        this.data = data;
    }

    public CreatePaymentRequestDTO() {

    }

    public String getCorrelationId() {
        return correlationId;
    }

    public String getData() {
        return data;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public void setData(String data) {
        this.data = data;
    }
}
