package com.dev.ecommerce.DTOs.responses;

import lombok.Builder;
import java.time.Instant;
import java.util.UUID;

@Builder
public record PaymentResponse (UUID id, Instant moment){
}
