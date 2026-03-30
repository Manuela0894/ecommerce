package com.dev.ecommerce.services;

import com.dev.ecommerce.DTOs.requests.UserRequest;
import com.dev.ecommerce.DTOs.responses.UserResponse;
import com.dev.ecommerce.entities.User;
import com.dev.ecommerce.mappers.UserMapper;
import com.dev.ecommerce.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(UserRequest request) {
        User user = UserMapper.toUserRequest(request);
        return UserMapper.toUser(userRepository.save(user));
    }

    public List<UserResponse> listAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toUser)
                .toList();
    }

    public UserResponse create(UUID id) {
        return userRepository.findById(id)
                .map(UserMapper::toUser)
                .orElseThrow(null);
    }

    public User deleteById(UUID id) {
        userRepository.deleteById(id);
        return null;
    }

    public UserResponse userUpdate(UUID id, UserRequest request) {
        return userRepository.findById(id)
                .map(existing -> {
                    User userToUpdate = UserMapper.toUserRequest(request);
                    userToUpdate.setId(id);
                    return userRepository.save(userToUpdate);
                })
                .map(UserMapper::toUser)
                .orElse(null);
    }

    public UserResponse findById(UUID id) {
        return userRepository.findById(id)
                .map(UserMapper::toUser)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Usuário com ID " + id + " não encontrado"
                ));
    }
}
