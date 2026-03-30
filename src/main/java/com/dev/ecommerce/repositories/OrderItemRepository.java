package com.dev.ecommerce.repositories;

import com.dev.ecommerce.entities.OrderItem;
import com.dev.ecommerce.entities.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}
