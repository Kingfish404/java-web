package com.achacker.dao;

import com.achacker.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 模糊查询
    List<User> getUserLike(Map map);

    // 查询
    @Select("SELECT * from user")
    List<User> getUserList();

    // 精确查询
    @Select("SELECT * from user where id=#{id}")
    User getUserById(@Param("id") int id_temp);

    // 添加用户
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int it);
}
