package com.djl.satoken.utils;



import java.io.Serializable;

/**
 * @Author: djl
 * @Date: 2020/6/22 15:18
 * @Version 1.0
 */
public class R<T> implements Serializable {


    private static final long serialVersionUID = -3733630471742102544L;


    private Integer code;


    private String msg = "";


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

    public static R ok() {
        return new R() {
            {
                setMsg("操作成功");
                setCode(ResultCodeEnum.SUCCESS.getCode());
            }
        };
    }

    public static R ok(Object data) {
        return new R() {
            {
                setMsg("操作成功");
                setCode(ResultCodeEnum.SUCCESS.getCode());
                setData(data);
            }
        };
    }



    public static R error() {
        return new R() {
            {
                setCode(ResultCodeEnum.FAIL.getCode());
                setMsg("未知的错误");
            }
        };
    }

    public static R error(int errorCode, String msg) {
        return new R() {
            {
                setCode(errorCode);
                setMsg(msg);
            }
        };
    }

    public static R error(String msg) {
        return new R() {
            {

                setCode(ResultCodeEnum.FAIL.getCode());
                setMsg(msg);
            }
        };
    }

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
