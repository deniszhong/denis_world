package com.denis.zhong.world.common.exception;

public class BizException extends RuntimeException{

    protected String code;

    public BizException(){
        super();
    }

    public BizException(String message){
        super(message);
    }

    public BizException(String message, Throwable cause) {

        super(message, cause);
    }

    public BizException(String message,String code){
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
