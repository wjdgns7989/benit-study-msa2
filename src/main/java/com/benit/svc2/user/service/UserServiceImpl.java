package com.benit.svc2.user.service;

import com.benit.svc2.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    public List<UserDto> getUsers() {
        List<UserDto> resultList = new ArrayList<UserDto>();

        resultList.add(
                UserDto.builder()
                        .name("김현서")
                        .phoneNumber("010-8383-8585")
                        .address("영등포구 여의나루로45")
                        .age(25)
                        .build()
        );

        resultList.add(
                UserDto.builder()
                        .name("김진수")
                        .phoneNumber("010-2424-6653")
                        .address("마포구 강변북로22")
                        .age(65)
                        .build()
        );

        return resultList;
    }



}
