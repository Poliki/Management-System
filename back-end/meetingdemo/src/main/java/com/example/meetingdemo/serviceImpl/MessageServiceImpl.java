package com.example.meetingdemo.serviceImpl;

import com.example.meetingdemo.mapper.DepartmentMapper;
import com.example.meetingdemo.mapper.MessageMapper;
import com.example.meetingdemo.mapper.PlaceMapper;
import com.example.meetingdemo.pojo.Department;
import com.example.meetingdemo.pojo.Message;
import com.example.meetingdemo.pojo.Place;
import com.example.meetingdemo.res.Result;
import com.example.meetingdemo.service.MessageService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private PlaceMapper placeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;



    @Override
    public Result addMessage(Message message)throws ParseException {
        if (message.getmName() != null && message.getdId() != null
         && message.getpId() != null && message.getmHost() != null
         && message.getmContent() != null && message.getmDate() != null) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dates=simpleDateFormat.format(message.getmDate());


            Date date=simpleDateFormat.parse(dates);
            message.setmDate(date);


            System.out.println(message.getmDate());
            messageMapper.insertSelective(message);
            return Result.successMessage(200, "会议记录录入成功！");
        }
        else
            return Result.failMessage(400, "信息填写不全,录入失败");
    }

    @Override
    public Result queryAllMessage(Message message) {
        List<Message> list1 = messageMapper.select(message);
        if (list1.size() <= 0) {
            return Result.failMessage(400, "没有记录，查询失败！");
        } else {

            //封装部门、地点
            List<Message>  list2 = new ArrayList<Message>();

            for (Message m : list1) {
                Department department = departmentMapper.selectByPrimaryKey(m.getdId());
                m.setDepartment(department);

                Place place = placeMapper.selectByPrimaryKey(m.getpId());
                m.setPlace(place);

                list2.add(m);
            }

            return Result.success(200, list2);
        }
    }
    @Override
    public Result queryMessage(Message message) {
        if (message != null) {

            Message message1 = messageMapper.selectOne(message);

            Department department = departmentMapper.selectByPrimaryKey(message1.getdId());
            message1.setDepartment(department);

            Place place = placeMapper.selectByPrimaryKey(message1.getpId());
            message1.setPlace(place);

            return Result.success(200,message1);

        } else
            return Result.failMessage(400, "没有记录，查询失败！");
    }

    //模糊查询名字查询相对应的会议信息
    public Result queryMessageByName(Message message){
        if (message != null) {
            List<Message> list1=messageMapper.queryByName(message);
            System.out.println(list1);
            List list2=new ArrayList();
            for (Message m : list1) {
                Department department = departmentMapper.selectByPrimaryKey(m.getdId());
                m.setDepartment(department);

                Place place = placeMapper.selectByPrimaryKey(m.getpId());
                m.setPlace(place);

                list2.add(m);
            }

            return Result.success(200,list2);

        } else
            return Result.failMessage(400, "没有记录，查询失败！");



    }
    @Override
    public Result queryMessageByDate(Object date1s, Object date2s,Integer integer) throws ParseException {
        if (date1s != null && date2s != null )
        {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = simpleDateFormat.parse((String) date1s);
            Date date2 = simpleDateFormat.parse((String) date2s);

            List<Message> list1 = messageMapper.queryByDate(date1,date2,integer);
            List<Message> list2 = new ArrayList<Message>();

            for (Message m : list1) {
                Department department = departmentMapper.selectByPrimaryKey(m.getdId());
                m.setDepartment(department);

                Place place = placeMapper.selectByPrimaryKey(m.getpId());
                m.setPlace(place);

                list2.add(m);
            }

            System.out.println(list2);

            return Result.success(200, list2);

        }else
            return Result.failMessage(400, "没有记录，查询失败！");
    }

    @Override
    public Result updateMessageByMid(Message message) {
        if (message.getmId()!=null){
            if (message.getDepartment().getdName().length()==1){
                message.setdId( Integer.parseInt(message.getDepartment().getdName()));
            }else {
                message.setdId(message.getDepartment().getdId());
            }
            if (message.getPlace().getpName().length()==1){
                message.setpId( Integer.parseInt(message.getPlace().getpName()));
            }else {
                message.setpId(message.getPlace().getpId());
            }
            return Result.success(200, messageMapper.updateByPrimaryKey(message));
        }
        return Result.failMessage(400, "修改失败");
    }

    @Override
    public Result deleteMessageByMid(Message message) {
        if (message.getmId()!=null){
            return Result.success(200, messageMapper.deleteByPrimaryKey(message));
        }
        return Result.failMessage(400, "删除失败");
    }

    @Override
    public Result getPlace() {
        return Result.success(200, placeMapper.selectAll());

    }

    @Override
    public Result getDepartment() {
        return Result.success(200, departmentMapper.selectAll());

    }
}
