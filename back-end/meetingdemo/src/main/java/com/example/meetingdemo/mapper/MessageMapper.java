package com.example.meetingdemo.mapper;

import com.example.meetingdemo.pojo.Message;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;


@Repository("messageMapper")
@org.apache.ibatis.annotations.Mapper
public interface MessageMapper extends Mapper<Message> {
    @Select("select * from  message where mDate > #{date1} and #{date2} > mDate and uId=#{integer}")
    List<Message> queryByDate(Date date1, Date date2, Integer integer);

    List<Message> queryByName(Message message);
}
