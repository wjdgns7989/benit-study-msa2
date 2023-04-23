package com.benit.svc2.user.controller;

import com.benit.svc2.user.dto.UserDto;
import com.benit.svc2.user.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // 가게 목록 조회
    @GetMapping("/user/total-list")
    public List<UserDto> getUsers() {
        StopWatch stopWatch = new StopWatch("userTotalList");
        stopWatch.start();
        var userList = userService.getUsers();
        stopWatch.stop();
        userList.forEach(userDto -> log.info("- {}", userDto));

        log.info("id : {}, 밀리세컨시간 : {}ms", stopWatch.getId(), stopWatch.getLastTaskTimeMillis());
        return userList;
    }

    @GetMapping("/user/{userName}")
    public UserDto selectStore(@PathVariable(name="userName") String userName) {

        var userInfo = userService.selectUser(userName);

        return userInfo;
    }

    @PostMapping("/user/users")
    public UserDto saveStore(@Valid @RequestBody UserDto userDto) {

        log.info("파라미터 : {}", userDto);

        StopWatch stopWatch = new StopWatch("userSave");
        stopWatch.start();
        var insertCount = userService.insertUser(userDto);
        stopWatch.stop();

        log.info("id : {}, 밀리세컨시간 : {}ms", stopWatch.getId(), stopWatch.getLastTaskTimeMillis());
        log.info("건 수 : {}", insertCount);
        return userDto;
    }




    @PutMapping("/user/{userName}")
    public void updateStore(@RequestBody UserDto userDto, @PathVariable String userName) {

        log.info("파라미터 : {}", userName);
        log.info("파라미터 : {}", userDto);

        StopWatch stopWatch = new StopWatch("userUpdate");
        stopWatch.start();
        userService.updateUser(userDto, userName);
        stopWatch.stop();

        log.info("id : {}, 밀리세컨시간 : {}ms", stopWatch.getId(), stopWatch.getLastTaskTimeMillis());

    }

    @DeleteMapping("/user/{userName}")
    public void deleteUser(@PathVariable String userName) {

        log.info("파라미터 : {}", userName);

        StopWatch stopWatch = new StopWatch("storeDelete");
        stopWatch.start();
        userService.deleteUser(userName);
        stopWatch.stop();

        log.info("id : {}, 밀리세컨시간 : {}ms", stopWatch.getId(), stopWatch.getLastTaskTimeMillis());

    }
}
