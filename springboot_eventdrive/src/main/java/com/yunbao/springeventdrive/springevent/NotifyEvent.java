package com.yunbao.springeventdrive.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: djl
 * @Date: 2020/12/16 9:54
 * @Version 1.0
 */
public class NotifyEvent extends ApplicationEvent {

    private String msg;

    public NotifyEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
