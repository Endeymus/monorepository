package com.endeymus.cloud.service.api;

import com.endeymus.cloud.model.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * API взаимодействия с User
 */
public interface UserService {

    /**
     * Получения пользователя по логину
     * @param login логин пользователя
     */
    Flux<UserDto> findUserByName(String login);

    /**
     * Сохранение нового пользователя
     * @param userDto данные о пользователе
     */
    Mono<UserDto> saveUser(UserDto userDto);


}
