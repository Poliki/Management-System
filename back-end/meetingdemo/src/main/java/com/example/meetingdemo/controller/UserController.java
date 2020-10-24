package com.example.meetingdemo.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.meetingdemo.pojo.User;
import com.example.meetingdemo.res.Result;
import com.example.meetingdemo.service.UserService;
import com.example.meetingdemo.utils.JWTUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {
    //创建userService对象并自动装配
    @Autowired
    private UserService userService;

    //登录
    @PostMapping(value = "/login", produces = { "application/json;charset=UTF-8" })
    public Object login(@RequestBody User user)  {
        System.out.println("---------login---------");
        Result login = userService.login(user);

        if (login.getCode()!=200){
            System.out.println(user+"1");
            return login;
        }else {
            String token = JWTUtil.sign(user.getuName(), user.getuPassword());
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("token", token);
            jsonObject.put("user", login.getData());
            jsonObject.put("code",login.getCode());
            System.out.println(jsonObject);
            return jsonObject;
        }
    }


    //注册
    @PostMapping(value = "/register", produces = { "application/json;charset=UTF-8" })
    public Result register(@RequestBody User user)  {
        System.out.println("---------register---------");
        //获取用户输入的用户名和密码
        return userService.register(user);
    }
    
    //获取用户列表
    @RequiresAuthentication
    @RequiresRoles("admin")
    @GetMapping(value = "/getUser")
    public Result getUser()  {
        System.out.println("---------getUser---------");
        //获取用户输入的用户名和密码
        return userService.getAllUser();
    }


    //修改用户权限
    @RequiresAuthentication
    @RequiresRoles("admin")
    @PostMapping(value = "/setUser", produces = { "application/json;charset=UTF-8" })
    public Result setRole(@RequestBody User user) {
        System.out.println("---------setRole---------");
        if (user!=null)
        {
         return userService.setRole(user);
        }
        return  new Result(401,null,"null");
        }

    //删除用户
    @RequiresAuthentication
    @RequiresRoles("admin")
    @PostMapping(value = "/deleteUser", produces = { "application/json;charset=UTF-8" })
    public Result deleteUser(@RequestBody User user) {
        System.out.println("---------deleteUser---------");
        if (user!=null)
        {
            return userService.deleteUser(user);
        }
        return  new Result(401,null,"null");
    }



    /**
    * @RequiresAuthentication
    * 此注解等效于 if (subject.isAuthenticated())
    * 用于判断用户是否登录了，请求头需要加上token
    *
    *  if (subject.isAuthenticated()) {
    *             return new ResponseBean(200, "You are already logged in", null);
    *         } else {
    *             return new ResponseBean(200, "You are guest", null);
    *         }

    * @RequiresRoles("admin")
    * 用于查看用户的身份，
    * 只有对应上里面的字段才能成功进入此方法
    * @return
    */

    //用于测试的接口
    @GetMapping(value = "/test")
    public Result test()  {
        System.out.println("---------test---------");
        return userService.test();
    }


}
