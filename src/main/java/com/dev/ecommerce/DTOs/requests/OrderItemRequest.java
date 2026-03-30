package com.dev.ecommerce.DTOs.requests;

import com.dev.ecommerce.entities.Order;
import com.dev.ecommerce.entities.Product;

public record OrderItemRequest (int quantity, double price, Order order, Product product) {
}
