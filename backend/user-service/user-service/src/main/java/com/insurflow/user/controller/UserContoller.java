package com.insurflow.user.controller;

import com.insurflow.user.Service.UserService;
import com.insurflow.user.dto.request.UserRequestDTO;
import com.insurflow.user.dto.response.UserResponse;
import com.insurflow.user.payload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserContoller {

    private  final UserService userService;
    @PostMapping
    public ApiResponse<UserResponse> createUser(@Valid @RequestBody UserRequestDTO requestDTO){
        UserResponse user=userService.createUser(requestDTO);
        return  ApiResponse.<UserResponse>builder()
                .success(true)
                .message("User created Successflly")
                .data(user)
                .build();
    }
    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserResponse getUserById( @PathVariable Long id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
