package com.dev.ecommerce.DTOs.requests;

import com.dev.ecommerce.enums.EOrderStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record OrderRequest (UUID clientId,
                            List<OrderItemRequest> items) {

}
