package com.benit.svc2.user.dao;

import com.benit.svc2.user.dto.UserDto;

import java.util.List;

public interface UserDao {

    public List<UserDto> getUserList();

    public UserDto selectUser(String userName);

    public int insertUser(UserDto userDto);

    public void updateUser(UserDto userDto);

    public void deleteUser(String userName);
}
