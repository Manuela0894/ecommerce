package com.dev.ecommerce.mappers;

import com.dev.ecommerce.DTOs.requests.OrderRequest;
import com.dev.ecommerce.DTOs.responses.OrderResponse;
import com.dev.ecommerce.entities.Order;
import com.dev.ecommerce.entities.User;
import com.dev.ecommerce.enums.EOrderStatus;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class OrderMapper {

    public static Order toOrderRequest(OrderRequest orderRequest, User user) {
        return Order
                .builder()
                .status(EOrderStatus.WAITING_PAYMENT)
                .moment(LocalDate.now())
                .client(user)
                .build();
    }

    public static OrderResponse toOrder (Order order) {
        return OrderResponse
                .builder()
                .id(order.getId())
                .status(order.getStatus())
                .moment(order.getMoment())
                .clientName(order.getClient().getName())
                .build();
    }


}
