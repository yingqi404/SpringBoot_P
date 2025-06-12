package com.wyq.springboot_wyq.controller;

import com.wyq.springboot_wyq.pojo.ResponseMessage;
import com.wyq.springboot_wyq.pojo.User;
import com.wyq.springboot_wyq.pojo.dto.UserDto;
import com.wyq.springboot_wyq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController//作用：允许接口的方法返回对象，且该对象转为Json文本
@RequestMapping("/user") //localhost:8080/user/**
public class UserController {
    //用不同的映射注解来实现增删改查
    //REST：HTTP协议中有不同的发生请求的方式，GET,POST,PUT,DELETE等，
    // 新增用户：http://localhost:8080/user POST
    // 删除用户：http://localhost:8080/user/1
    // 修改用户：http://localhost:8080/user PUT
    // 查询用户：http://localhost:8080/user/1 GET
    // 查询多个用户：http://localhost:8080/users GET

    @Autowired//自动注入Service层代码，此注释相当于将类不用new就可以实例化
    IUserService userService;

    // 增
    @PostMapping (value = "/user")  //前端请求的地址 -> URL:localhost:8080/user   对应的method:post
    //此处可以直接把dao层的User类对象作为形参，但是企业级项目中不够规范。所以需要专们新定义的 DTO:数据传输类的对象
    //DTO:Data Transfer Object，数据传输对象，需要一个数据传输类接收客户端请求的参数，因为请求参数不一定就是pojo里User类里的成员参数，所以规范的项目通常需要一个DTO类
    public ResponseMessage add(@Validated @RequestBody UserDto user){//RequestBody:客户端传进来的参数是一个Json文本，RequestBody把Json转为对象
        User newuser = userService.add(user);
        return ResponseMessage.success(newuser);
    }

    // 查
    @GetMapping("/{userId}")//前端请求的地址 -> URL:localhost:8080/user/1
    public ResponseMessage get(@PathVariable Integer userId){
        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }

    // 改
    @PutMapping
    public ResponseMessage update(@Validated @RequestBody UserDto user){
        User userNew = userService.edit(user);
        return ResponseMessage.success(userNew);
    }

    // 删
    @DeleteMapping("/{userId}")
    public ResponseMessage delete(@PathVariable Integer userId){
        userService.delete(userId);
        return ResponseMessage.success();
    }

}