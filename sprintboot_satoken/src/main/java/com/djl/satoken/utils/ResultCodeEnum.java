package com.djl.satoken.utils;

/**
 * @Author:
 * @Date: 2020/6/22 11:17
 * @Version 1.0
 * 返回结果状态码
 */
public enum ResultCodeEnum {

    /**
     * 成功
     */
    SUCCESS(200,"成功"),

    /**
     * 失败
     */
    FAIL(400,"失败"),


    /***
     * 用户未登录
     */
    REQUEST_WITHOUT_TOKEN(401,"用户未登录"),

    /***
     * token过期或者无效
     */
    REQUEST_WITH_INVALID_TOKEN(402,"token过期或无效"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROE(500,"未知异常");


    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


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
}
