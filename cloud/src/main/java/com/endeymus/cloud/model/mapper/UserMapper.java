package com.endeymus.cloud.model.mapper;

import com.endeymus.cloud.model.dto.UserDto;
import com.endeymus.cloud.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);
    User toUser(UserDto user);
}
