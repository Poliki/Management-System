package com.example.meetingdemo.controller;


import com.example.meetingdemo.pojo.Message;
import com.example.meetingdemo.pojo.User;
import com.example.meetingdemo.res.Result;
import com.example.meetingdemo.service.MessageService;
import com.example.meetingdemo.service.UserService;
import com.example.meetingdemo.utils.JWTUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;


    @RequiresAuthentication
    @RequiresPermissions("add")
    @PostMapping(value = "/addMessage", produces = { "application/json;charset=UTF-8" })
    public Result addMessage(@RequestBody Message message,
                             HttpServletRequest httpServletRequest) throws ParseException {
        System.out.println("---------addMessage---------");
        //根据请求头获取token获得用户信息
        User user = userService.getByUname(JWTUtil.getUsername(httpServletRequest.getHeader("token")));
        message.setuId(user.getuId());
        return messageService.addMessage(message);
    }

    @RequiresAuthentication
    @RequiresPermissions("search")
    @PostMapping(value = "/queryAll")
    public Result queryAllMessage( HttpServletRequest httpServletRequest)  {
        System.out.println("---------queryAllMessage---------");
        //根据请求头获取token获得用户信息
        User user = userService.getByUname(JWTUtil.getUsername(httpServletRequest.getHeader("token")));
        Message message=new Message();
        message.setuId(user.getuId());
        return messageService.queryAllMessage(message);
    }


    @RequiresAuthentication
    @RequiresPermissions("search")
    @PostMapping(value = "/query", produces = { "application/json;charset=UTF-8" })
    public Result queryMessage(@RequestBody Message message,HttpServletRequest httpServletRequest)  {
        System.out.println("---------queryMessage---------");
        //根据请求头获取token获得用户信息
        User user = userService.getByUname(JWTUtil.getUsername(httpServletRequest.getHeader("token")));
        message.setuId(user.getuId());
        return messageService.queryMessage(message);
    }

//    @RequiresAuthentication
    @RequiresPermissions("search")
    @PostMapping(value = "/queryByName", produces = { "application/json;charset=UTF-8" })
    public Result queryMessageByName(@RequestBody Message message,HttpServletRequest httpServletRequest)  {
        System.out.println("---------queryMessageByName---------");
        //根据请求头获取token获得用户信息
        User user = userService.getByUname(JWTUtil.getUsername(httpServletRequest.getHeader("token")));
        message.setuId(user.getuId());
        return messageService.queryMessageByName(message);
    }


    @RequiresAuthentication
    @RequiresPermissions("search")
    @PostMapping(value = "/queryByDate" )
    public Result queryMessageByDate(@RequestBody Map<String, String> data, HttpServletRequest httpServletRequest) throws ParseException {
        System.out.println("---------queryMessageByDate---------");
        //根据请求头获取token获得用户信息
        User user = userService.getByUname(JWTUtil.getUsername(httpServletRequest.getHeader("token")));
        return messageService.queryMessageByDate(data.get("date1"),data.get("date2"),user.getuId());
    }


    @RequiresAuthentication
    @RequiresPermissions("update")
    @PostMapping(value = "/updateMessage" , produces={ "application/json;charset=UTF-8" })
    public Result updateMessage(@RequestBody Message message,HttpServletRequest httpServletRequest){
        System.out.println("---------updateMessage---------");
        //根据请求头获取token获得用户信息
        User user = userService.getByUname(JWTUtil.getUsername(httpServletRequest.getHeader("token")));
        message.setuId(user.getuId());
        return messageService.updateMessageByMid(message);
    }


    @RequiresAuthentication
    @RequiresPermissions("delete")
    @PostMapping(value = "/deleteMessage" , produces={ "application/json;charset=UTF-8" })
    public Result deleteMessage(@RequestBody Message message,HttpServletRequest httpServletRequest){
        System.out.println("---------deleteMessage---------");
        //根据请求头获取token获得用户信息
        User user = userService.getByUname(JWTUtil.getUsername(httpServletRequest.getHeader("token")));
        message.setuId(user.getuId());
        return messageService.deleteMessageByMid(message);
    }

//    @RequiresAuthentication
//    @PostMapping(value = "/getPlace" , produces={ "application/json;charset=UTF-8" })
//    public Result getPlace(){
//        System.out.println("---------getPlace---------");
//        return messageService.getPlace();
//    }
//
//    @RequiresAuthentication
//    @PostMapping(value = "/getDepartment" , produces={ "application/json;charset=UTF-8" })
//    public Result getDepartment(){
//        System.out.println("---------getDepartment---------");
//        return messageService.getDepartment();
//    }
}
