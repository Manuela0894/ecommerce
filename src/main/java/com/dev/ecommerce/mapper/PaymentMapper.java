package com.dev.ecommerce.mapper;

import com.dev.ecommerce.DTOs.requests.PaymentRequest;
import com.dev.ecommerce.DTOs.responses.PaymentResponse;
import com.dev.ecommerce.entities.Payment;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class PaymentMapper {

    public static Payment toPaymentRequest(PaymentRequest paymentRequest) {
        return Payment
                .builder()
                .moment(paymentRequest.moment())
                .build();
    }

    public static PaymentResponse toPayment(Payment payment) {
        return PaymentResponse
                .builder()
                .moment(payment.getMoment())
                .build();
    }

}
