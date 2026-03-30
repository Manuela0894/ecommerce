package com.dev.ecommerce.DTOs.requests;

import java.time.Instant;

public record PaymentRequest (Instant moment) {
}
