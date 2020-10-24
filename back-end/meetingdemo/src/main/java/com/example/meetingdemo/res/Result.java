package com.example.meetingdemo.res;

import com.alibaba.fastjson.JSON;


public class Result<T> {
    private int code;
    private String msg;
    private T data;


    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static <T> Result<T> fail(Integer code,T data){
        Result<T> retResult = new Result<T>();
        retResult.setCode(code);
        retResult.setData(data);
        return retResult;
    }

    public static <T> Result<T> failMessage (Integer code, String msg){
        Result<T>  retResult = new Result<T>();
        retResult.setCode(code);
        retResult.setMsg(msg);
        return retResult;
    }

    public static<T> Result<T> successMessage(Integer code,String msg) {

        Result<T> retResult = new Result<T>();
        retResult.setCode(code);
        retResult.setMsg(msg);
        return retResult;
    }

    public static<T> Result<T> success(Integer code,T data){
        Result<T> retResult  = new Result<T>();
        retResult.setCode(code);
        retResult.setData(data);
        return retResult;
    }



}