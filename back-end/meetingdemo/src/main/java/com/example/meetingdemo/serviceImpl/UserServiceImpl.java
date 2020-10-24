package com.example.meetingdemo.serviceImpl;

import com.example.meetingdemo.mapper.UserMapper;
import com.example.meetingdemo.pojo.User;
import com.example.meetingdemo.service.UserService;
import com.example.meetingdemo.utils.Uidsort;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.meetingdemo.res.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    //自动装配
    @Autowired
    private UserMapper userMapper;

    //登录的方法
    @Override
    public Result login(User user) {
        //user用户名和密码不为空且在数据库能查到记录则返回状态码为200，以及这个用户信息到控制层
        if( user.getuName() != null && user.getuPassword() != null && userMapper.selectOne(user) != null){
            return Result.success(200, userMapper.selectOne(user) );
        }
        else
            //否则发状态码400以及提示
            return Result.failMessage(400, "账号或密码错误");
    }

    @Override
    public Result register(User user) {
        if (user.getuName() != null && user.getuPassword() != null && CheckName(user)){
         return  Result.success(200, userMapper.insertSelective(user));
        }
        else
         return Result.failMessage(400,"用户名已被使用");
    }

    //判断是否有重名用户
    public Boolean CheckName(User user){
        int a=0;
        List<User> users = userMapper.selectAll();
        for (User u : users) {
            if (u.getuName().equals(user.getuName())){
                a=1;
                break;
            }
        }
        if (a==0)
            return true;
        else
            return false;
    }

    @Override
    //token通过用户名获取用户对象
    public User getByUname(String uName) {
        User user=new User();
        user.setuName(uName);
        return userMapper.selectOne(user);
    }

    @Override
    //获取所有的用户
    public Result getAllUser(){
        List list=userMapper.selectAll();
        //对所有用户进行排序，根据uid
        Collections.sort(list, new Uidsort());
        return Result.success(200, list);
    }

    @Override
    public Result setRole(User user) {
        if (user.getuId()!=null)
        userMapper.updateByPrimaryKeySelective(user);
        return Result.successMessage(200,"success!");
    }

    @Override
    public Result deleteUser(User user) {
        userMapper.deleteByPrimaryKey(user);
        return Result.successMessage(200,"success!");
    }

    //测试
    public Result test() {
        return Result.success(200, userMapper.selectAll());
    }


}
