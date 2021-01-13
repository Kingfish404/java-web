package com.achacker.dao;

import com.achacker.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 查询
    List<User> getUserList();

    // 精确查询
    User getUserById(int id);

    // 添加用户
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int it);
}
