package com.wyq.springboot_wyq.pojo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

//Dto：Data Transfer Object(数据传输对象)
public class UserDto {
    private Integer userId;

    //userName
    @NotBlank(message = "ユーザー名を入力してください")//去除空格
    private String userName;

    //password
    @NotBlank(message = "パスワードを入力してください")//@NotBlank：只用于检验字符串类型是否为空格或不为空。去除空格
    @Length(min = 6,max = 12)//规定密码长度
    private String password;

    //email
    @Email(message = "正しい形式のパスワードを入力してください")
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
