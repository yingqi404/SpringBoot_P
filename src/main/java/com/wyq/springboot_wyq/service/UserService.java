package com.wyq.springboot_wyq.service;

import com.wyq.springboot_wyq.dao.UserRepository;
import com.wyq.springboot_wyq.pojo.User;
import com.wyq.springboot_wyq.pojo.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   //配置成Spring的bean
//实现接口的类
public class UserService implements IUserService {

    @Autowired//自动装配userRepository
    UserRepository userRepository;

    @Override
    public User add(UserDto userDto) {
        //创建User类对象user
        User user = new User();
        //BeanUtils.copyProperties(需要copy的对象,copy到哪个对象中去)，userDto --(copy)-> user对象
        BeanUtils.copyProperties(userDto,user);
        return userRepository.save(user);//save内置方法可以调用 增 和 改，通过判断实参是否有id来实现增还是改，有id:改，无id:增。
        //调用数据访问类的方法
//        return user;
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("user does not exist 引数异常！！");
        });
    }

    @Override
    public User edit(UserDto userDto) {
        //创建User类对象user
        User user = new User();
        //BeanUtils.copyProperties(需要copy的对象,copy到哪个对象中去)，userDto --(copy)-> user对象
        BeanUtils.copyProperties(userDto,user);
        return userRepository.save(user);
    }

    @Override
    public void delete(Integer userId) {
         userRepository.deleteById(userId);
    }


}
