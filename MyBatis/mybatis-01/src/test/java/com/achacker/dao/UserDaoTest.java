package com.achacker.dao;

import com.achacker.pojo.User;
import com.achacker.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void testGetUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "%fish");
        List<User> users = userMapper.getUserLike(map);

        System.out.println("In GetUserLike");
        for (User user : users) {
            System.out.println("Like =" + user);
        }
        sqlSession.close();
    }

    @Test
    public void testGetUser() {
        // 第一步：获取SqlSession对象
        SqlSession sqlSession = null;

        try {
            sqlSession = MybatisUtils.getSqlSession();
            // 方式一:getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userlist = userMapper.getUserList();

            for (User user : userlist) {
                System.out.println(user.toString());
            }

//            // 方式二:不推荐使用
//            userlist = sqlSession.selectList("com.achacker.dao.UserMapper.getUserList");
//            for (User user : userlist) {
//                System.out.println(user.toString());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = userMapper.getUserById(1);

            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testAdduer() {
        SqlSession sqlSession = null;
        testGetUser();
        try {
            sqlSession = MybatisUtils.getSqlSession();

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = new User(4, "赤风", "1234");

            int result = userMapper.addUser(user);
            if (result > 0) {
                System.out.println("Insert successful!");
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        testGetUser();
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int result = userMapper.updateUser(new User(1, "刺客", "1234"));
        if (result > 0) {
            if (result > 0) {
                System.out.println("Update successful!");
            }
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int result = userMapper.deleteUser(4);
        if (result > 0) {
            if (result > 0) {
                System.out.println("Delete successful!");
            }
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
