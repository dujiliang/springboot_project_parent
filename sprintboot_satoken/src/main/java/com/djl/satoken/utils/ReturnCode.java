package com.djl.satoken.utils;

/**
 * @Author：dcy
 * @Description:
 * @Date: 2021/1/11 9:29
 */
public enum ReturnCode {

    /*1000～1999 区间表示参数错误*/
    /*2000～2999 区间表示用户错误*/
    /*3000～3999 区间表示接口异常*/

    SUCCESS(1, "操作成功"),
    ERROR(0, "操作失败"),
    // 校验公共错误
    CHECK_ERROR(1000, "校验公共错误"),
    // token错误
    TOKEN_ERROR(2000, "token错误"),
    NO_TOKEN_ERROR(2001, "没有token，请重新登录"),
    USER_PASSWORD_ERROR(2002, "用户名和密码错误，请重新输入"),
    USER_UPDATE_PASS_ERROR(2005, "当前密码输入错误，请重新输入"),
    USER_UPDATE_PASS2_ERROR(2006, "两次密码输入不一致，请重新输入"),
    USER_LOCKED_ERROR(2003, "用户已锁定"),
    USER_NOROLE_LOCKED_ERROR(2004, "没有角色"),
    USER_NOPERMISSION_LOCKED_ERROR(2005, "没有权限"),
    // 其他exe 错误
    CRON_EXPRESSION_ERROR(3001, "cron表达式不正确"),
    SCHEDULER_EXPRESSION_ERROR(3002, "调度异常"),
    OTHER_ERROR(3000, "其他exe 错误");

    private Integer code;
    private String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
