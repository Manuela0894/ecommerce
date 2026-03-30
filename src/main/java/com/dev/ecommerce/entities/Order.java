package com.dev.ecommerce.entities;


import com.dev.ecommerce.enums.EOrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate moment;
    private EOrderStatus status;

    @ManyToOne
    @JoinColumn(name  = "client_id")
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    @JsonManagedReference
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderProducts = new ArrayList<>();

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderItem> orderProducts = getOrderProducts();
        for (OrderItem op : orderProducts) {
            sum += op.getOrder().getTotalOrderPrice();
        }
        return sum;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }

}
