package com.example.meetingdemo.service;

import com.example.meetingdemo.pojo.Message;
import com.example.meetingdemo.res.Result;

import java.text.ParseException;
import java.util.Date;

public interface MessageService {
    //录入会议信息
    public Result addMessage(Message message) throws ParseException;
    //浏览会议信息
    public Result queryAllMessage(Message message);
    //根据对象查询相对应的会议信息
    public Result queryMessage(Message message);
    //根据对象查询相对应的会议信息
    public Result queryMessageByName(Message message);
    //根据日期范围查询会议信息
    public Result queryMessageByDate(Object date1, Object date2, Integer integer) throws ParseException;
    //修改会议记录信息
    public Result updateMessageByMid(Message message);
    //删除会议记录信息
    public Result deleteMessageByMid(Message message);
    //获取会议地点
    public Result getPlace();
    //获取会议部门
    public Result getDepartment();
}
