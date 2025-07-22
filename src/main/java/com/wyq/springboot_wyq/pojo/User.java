package com.wyq.springboot_wyq.pojo;

import jakarta.persistence.*;



//@Table：将实体类映射成数据库的表
//@Entity：@Table(name=”“)：表明这是一个实体类。jpa中这两个注解一般一块使用，但是如果表名和实体类名相同的话，@Table可以省略。

@Table(name = "tb_user")
@Entity
public class User {

    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自动生成
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
