package com.dev.ecommerce.DTOs.responses;

import com.dev.ecommerce.entities.Order;
import com.dev.ecommerce.entities.Product;
import lombok.Builder;

import java.util.UUID;

@Builder
public record OrderItemResponse (UUID id, int quantity, double price, Order order, Product product) {
}
