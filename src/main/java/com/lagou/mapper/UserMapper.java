package com.lagou.mapper;

import com.lagou.pojo.User;

import java.util.List;

public interface UserMapper {

    //查询所有用户
    public List<User> findAll() throws Exception;


    //根据条件进行用户查询
    public User findByCondition(User user) throws Exception;

    //修改
    public void updateByCondition(User user) throws Exception;

    //新增
    public void insertUser(User user) throws  Exception;

    //删除
    public void deleteUser(User user);
}
