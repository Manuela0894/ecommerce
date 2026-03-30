package com.dev.ecommerce.service;

import com.dev.ecommerce.DTOs.requests.OrderRequest;
import com.dev.ecommerce.DTOs.responses.OrderResponse;
import com.dev.ecommerce.entities.Order;
import com.dev.ecommerce.entities.User;
import com.dev.ecommerce.mapper.OrderMapper;
import com.dev.ecommerce.repositories.OrderRepository;
import com.dev.ecommerce.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderResponse createOrder(OrderRequest request) {
        User client = userRepository.findById(request.clientId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        Order order = OrderMapper.toOrderRequest(request, client);
        order = orderRepository.save(order);
        return OrderMapper.toOrder(order);
    }



}
