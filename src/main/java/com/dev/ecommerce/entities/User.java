package com.dev.ecommerce.entities;


import com.dev.ecommerce.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;

    @Enumerated(EnumType.STRING)

    private ERole roles;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
}
