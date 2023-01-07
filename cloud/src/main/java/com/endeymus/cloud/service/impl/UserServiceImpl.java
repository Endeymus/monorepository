package com.endeymus.cloud.service.impl;

import com.endeymus.cloud.model.dto.UserDto;
import com.endeymus.cloud.model.mapper.UserMapper;
import com.endeymus.cloud.repository.UserR2dbcRepository;
import com.endeymus.cloud.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserR2dbcRepository r2dbcRepository;
    private final UserMapper userMapper;
    @Override
    public Flux<UserDto> findUserByName(String login) {
        return r2dbcRepository
                .findByLoginIn(List.of(login))
                .map(userMapper::toUserDto);
    }

    @Override
    @Transactional
    public Mono<UserDto> saveUser(UserDto userDto) {
        var user = userMapper.toUser(userDto);
        user.setId(UUID.randomUUID());
        return r2dbcRepository.save(user)
                .map(userMapper::toUserDto);
    }
}
