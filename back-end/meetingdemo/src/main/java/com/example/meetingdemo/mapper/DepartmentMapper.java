package com.example.meetingdemo.mapper;

import com.example.meetingdemo.pojo.Department;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository("departmentMapper")
public interface DepartmentMapper extends Mapper<Department> {

}
