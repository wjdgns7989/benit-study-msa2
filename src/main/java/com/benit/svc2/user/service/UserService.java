package com.benit.svc2.user.service;

import com.benit.svc2.user.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getUsers();

    public UserDto selectUser(String userName);

    public int insertUser(UserDto userDto);

    public void updateUser(UserDto userDto, String userName);

    public void deleteUser(String userName);
}
