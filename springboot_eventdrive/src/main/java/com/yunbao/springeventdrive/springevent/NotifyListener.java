package com.yunbao.springeventdrive.springevent;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author: djl
 * @Date: 2020/12/16 9:59
 * @Version 1.0
 */
@Component
public class NotifyListener {


    @EventListener
    public void sayHello(NotifyEvent event) {
        System.out.println("收听到事件:" + event.getMsg());
    }
}
