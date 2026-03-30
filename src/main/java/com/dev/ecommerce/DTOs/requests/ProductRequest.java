package com.dev.ecommerce.DTOs.requests;

public record ProductRequest (String name, String description, double price, String imgURL) {
}
