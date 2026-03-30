package com.dev.ecommerce.DTOs.responses;

import com.dev.ecommerce.enums.EOrderStatus;
import lombok.Builder;
import java.time.LocalDate;
import java.util.UUID;

@Builder
public record OrderResponse (UUID id, UUID client, String clientName, LocalDate moment, EOrderStatus status

) {
}
