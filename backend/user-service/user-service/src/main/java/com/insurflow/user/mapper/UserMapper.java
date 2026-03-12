package com.insurflow.user.mapper;

import com.insurflow.user.dto.request.UserRequestDTO;
import com.insurflow.user.dto.response.UserResponse;
import com.insurflow.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO dto);
    UserResponse toResponse(User user);
}
