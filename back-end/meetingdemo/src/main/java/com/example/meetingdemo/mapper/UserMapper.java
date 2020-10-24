package com.example.meetingdemo.mapper;

import com.example.meetingdemo.pojo.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

//在spring中生成名为userMapper的bean，供impl类生成实例使用
@Repository("userMapper")
public interface UserMapper extends Mapper<User> {


}


/**Mapper<T>,T为泛型，意为这个T可以是任何类包括你定义的，例如：
 我定义了一个的方法
 public void test(T t){
 System.out.println(t);
 }

 返回值为void，传递的参数是泛型，方法主体是输出参数

 那么我这里定义两个不同类型的参数，分别为int和String，
 int i=10;
 Siring s="okok!";

 由于这个方法的参数要求是泛型，因此这两个参数都可以使用
 test(i);
 test(s);

 在通用Mapper中，Mapper<T>的T为你定义的实体类即可

 **/