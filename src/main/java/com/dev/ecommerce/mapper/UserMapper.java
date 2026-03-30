package com.dev.ecommerce.mapper;

import com.dev.ecommerce.DTOs.requests.UserRequest;
import com.dev.ecommerce.DTOs.responses.UserResponse;
import com.dev.ecommerce.entities.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUserRequest(UserRequest userRequest) {
        return User
                .builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .phone(userRequest.phone())
                .password(userRequest.password())
                .build();
    }

    public static UserResponse toUser(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }



}
