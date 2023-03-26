package com.benit.svc2.controller;

import com.benit.svc2.dto.UserDto;
import com.benit.svc2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        var userList = userService.getUsers();

        userList.forEach(userDto -> log.info("- {}", userDto));

        return userList;
    }
}
