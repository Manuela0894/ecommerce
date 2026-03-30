package com.dev.ecommerce.mappers;

import com.dev.ecommerce.DTOs.requests.OrderItemRequest;
import com.dev.ecommerce.DTOs.responses.OrderItemResponse;
import com.dev.ecommerce.entities.OrderItem;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderItemMapper {


    public static OrderItem toOrderItemRequest (OrderItemRequest orderItemRequest){
        return OrderItem
                .builder()
                .order(orderItemRequest.order())
                .product(orderItemRequest.product())
                .price(orderItemRequest.price())
                .build();
    }

    public static OrderItemResponse toOrderItem (OrderItem orderItem){
        return OrderItemResponse
                .builder()
                .id(orderItem.getOrder().getId())
                .order(orderItem.getOrder())
                .product(orderItem.getProduct())
                .price(orderItem.getPrice())
                .build();
    }




}
