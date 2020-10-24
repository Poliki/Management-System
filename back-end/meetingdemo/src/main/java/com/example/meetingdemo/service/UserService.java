package com.example.meetingdemo.service;

import com.example.meetingdemo.pojo.User;
import com.example.meetingdemo.res.Result;

import java.awt.*;
import java.util.List;

public interface UserService {
    //登录
    public Result login(User user);
    //注册
    public Result register(User user);
    //根据uid验证用户
    public User getByUname(String uName);
    //获取所有用户
    public Result getAllUser();
    //更改用户身份
    public Result setRole(User user);
    //删除用户
    public Result deleteUser(User user);
    //测试
    public Result test();

}
