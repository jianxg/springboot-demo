package com.example.springbootdemo.common;

public class ResultMessage {
    //响应码
    private int code;

    public ResultMessage(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
