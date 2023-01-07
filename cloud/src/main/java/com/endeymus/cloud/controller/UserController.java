package com.endeymus.cloud.controller;

import com.endeymus.cloud.model.dto.UserDto;
import com.endeymus.cloud.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.endeymus.cloud.controller.UserController.BASE_PATH;
import static com.endeymus.cloud.utils.RestConstant.V1;

@RestController
@RequestMapping(V1 + BASE_PATH)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    public static final String BASE_PATH = "/user";

    @GetMapping
    public Flux<UserDto> getUser(
            @RequestParam String login
    ) {
        return userService.findUserByName(login);
    }

    @PostMapping
    public Mono<UserDto> saveUser(
            @RequestBody UserDto userDto
    ) {
        return userService.saveUser(userDto);
    }
}
