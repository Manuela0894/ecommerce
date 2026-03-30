package com.dev.ecommerce.controller;

import com.dev.ecommerce.DTOs.requests.UserRequest;
import com.dev.ecommerce.DTOs.responses.UserResponse;
import com.dev.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        UserResponse newUser = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserResponse>> listOfUser() {
        return ResponseEntity.ok(userService.listAllUsers());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<UserResponse> userListById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable UUID id,
            @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.userUpdate(id, request));
    }
}