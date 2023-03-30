package com.benit.svc2.user.service;

import com.benit.svc2.user.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getUsers();
}
