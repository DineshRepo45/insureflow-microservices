package com.insurflow.user.Service;

import com.insurflow.user.dto.request.UserRequestDTO;
import com.insurflow.user.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequestDTO requestDTO);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    void deleteUser(Long id);
}
