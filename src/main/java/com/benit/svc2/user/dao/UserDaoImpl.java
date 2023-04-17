package com.benit.svc2.user.dao;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public String getNowDate() {
        var now = (String) sqlSessionTemplate.selectOne("query.user.getNowDate");
        return now;
    }
}
