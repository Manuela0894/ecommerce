package com.dev.ecommerce.DTOs.responses;

import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderItemResponse (UUID id, int quantity, double price) {
}
