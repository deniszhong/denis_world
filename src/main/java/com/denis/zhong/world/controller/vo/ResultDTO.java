package com.denis.zhong.world.controller.vo;

import com.denis.zhong.world.common.constant.CommonConstant;

public class ResultDTO<T> {

    public ResultDTO() {
    }

    public ResultDTO(T data) {
        this.data = data;
    }

    public ResultDTO(String message, String code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    private String message = CommonConstant.SUCCESS_MESSAGE;

    private String code = CommonConstant.SUCCESS_CODE;

    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }
}
