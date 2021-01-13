package com.achacker.dao;

import com.achacker.pojo.User;
import com.achacker.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void testGetUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = usermapper.getUserList();

        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        User user = usermapper.getUserById(2);

        System.out.println(user);

        sqlSession.close();
    }
}
