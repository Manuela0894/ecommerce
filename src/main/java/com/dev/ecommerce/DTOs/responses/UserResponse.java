package com.dev.ecommerce.DTOs.responses;

import lombok.Builder;
import java.util.UUID;

@Builder
public record UserResponse (UUID id, String name, String email, String phone) {
}
