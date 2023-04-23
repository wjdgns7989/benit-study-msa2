package com.benit.svc2.user.dao;

import com.benit.svc2.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<UserDto> getUserList() {
        return sqlSessionTemplate.selectList("query.user.getUserList");
    }

    @Override
    public UserDto selectUser(String userName) {

        return sqlSessionTemplate.selectOne("query.user.selectUser", userName);
    }

    @Override
    public int insertUser(UserDto userDto) {
        return sqlSessionTemplate.insert("query.user.insertUser", userDto);
    }

    @Override
    public void updateUser(UserDto userDto) {
        sqlSessionTemplate.update("query.user.updateUser", userDto);
    }

    public void deleteUser(String userName) {
        sqlSessionTemplate.delete("query.user.deleteUser", userName);
    }
}
