package com.wyq.springboot_wyq.service;

import com.wyq.springboot_wyq.pojo.User;
import com.wyq.springboot_wyq.pojo.dto.UserDto;

public interface IUserService {
    /**
     * 插入用户
     *
     * @return
     * @Param user 参数
     */
    User add(UserDto user);


    /**
     * 插入用户
     * @Param userId 参数 用户ID
     * * @return
     */
    User getUser(Integer userId);

    /**
     * 修改用户
     * @Param user 修改用户对象
     * * @return
     */
    User edit(UserDto user);


    /**
     * 删除用户
     *
     * @Param user 删除用户对象
     * * @return
     */
    void delete(Integer userId);
}
