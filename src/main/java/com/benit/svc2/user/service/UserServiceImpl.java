package com.benit.svc2.user.service;

import com.benit.svc2.user.dao.UserDao;
import com.benit.svc2.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDto> getUsers() {
        var resultList = userDao.getUserList();

        resultList.forEach(userDto -> {
            log.info("가게정보 : {}", userDto);
        });

        return resultList;
    }

    @Override
    public UserDto selectUser(String userName) {
        return userDao.selectUser(userName);
    }

    @Override
    public int insertUser(UserDto userDto) {
        return userDao.insertUser(userDto);
    }

    @Override
    public void updateUser(UserDto userDto, String userName) {
        UserDto userDtoInfo = userDao.selectUser(userName);

        userDtoInfo.setPhoneNumber(userDto.getPhoneNumber());
        userDtoInfo.setAddress(userDto.getAddress());
        userDtoInfo.setAge(userDto.getAge());

        userDao.updateUser(userDtoInfo);


    }

    @Override
    public void deleteUser(String userName) {
        userDao.deleteUser(userName);
    }



}
