package com.dev.ecommerce.DTOs.responses;

import lombok.Builder;

@Builder
public record CategoryResponse (Long id, String name){
}
