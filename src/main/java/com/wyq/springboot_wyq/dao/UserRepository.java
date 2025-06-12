package com.wyq.springboot_wyq.dao;

import com.wyq.springboot_wyq.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository   //把当前类注册为Spring的bean
public interface UserRepository  extends CrudRepository<User,Integer> {//CrudRepository这个类可以自动实现增删改查的方法<类型:需要操作的类(用户类),前面的类的主键id是什么数据类型>
}
