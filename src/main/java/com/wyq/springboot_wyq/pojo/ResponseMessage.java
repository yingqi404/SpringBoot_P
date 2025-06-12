package com.wyq.springboot_wyq.pojo;

import org.springframework.http.HttpStatus;

public class ResponseMessage <T>{
    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseMessage(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;

    }

    //接口请求成功
    public static <T> ResponseMessage <T> success(T data) {
        return new ResponseMessage(HttpStatus.OK.value(), "success", data);
    }


    //接口请求成功
    public static <T> ResponseMessage <T> success() {
        return new ResponseMessage(HttpStatus.OK.value(), "success", null);
    }


}
