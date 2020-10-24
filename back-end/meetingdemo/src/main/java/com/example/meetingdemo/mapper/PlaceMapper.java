package com.example.meetingdemo.mapper;

import com.example.meetingdemo.pojo.Place;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("placeMapper")
public interface PlaceMapper extends Mapper<Place> {
}
