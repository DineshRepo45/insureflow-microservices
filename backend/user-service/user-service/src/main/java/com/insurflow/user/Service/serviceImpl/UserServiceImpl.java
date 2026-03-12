package com.insurflow.user.Service.serviceImpl;

import com.insurflow.user.Service.UserService;
import com.insurflow.user.dto.request.UserRequestDTO;
import com.insurflow.user.dto.response.UserResponse;
import com.insurflow.user.entity.User;
import com.insurflow.user.exception.ResourcesNotFoundException;
import com.insurflow.user.mapper.UserMapper;
import com.insurflow.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserResponse createUser(UserRequestDTO requestDTO) {
        log.info("Createing user with email {}",requestDTO.getEmail());
       User user=userMapper.toEntity(requestDTO);
       User saveUser=userRepository.save(user);
       log.info("user creted with id{}",saveUser.getId());
       return userMapper.toResponse(saveUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {
      return (List<UserResponse>) userRepository.findAll()
              .stream()
              .map(user->UserResponse.builder()
                      .id(user.getId())
                      .name(user.getName())
                      .email(user.getEmail())
                      .role(user.getRole())
                      .build()).collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user=userRepository.findById(id)
                .orElseThrow(()-> new ResourcesNotFoundException("User Not Found"));
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @Override
    public void deleteUser(Long id) {
userRepository.deleteById(id);
    }
}
