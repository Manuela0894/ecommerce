package com.dev.ecommerce.DTOs.responses;

import lombok.Builder;
import java.util.UUID;

@Builder
public record ProductResponse(UUID id, String name, String description, double price, String imgURL) {
}
