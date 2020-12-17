package com.yunbao.springeventdrive.springevent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: djl
 * @Date: 2020/12/16 9:55
 * @Version 1.0
 */
@Component
public class NotifyPublisher implements ApplicationContextAware {

    private ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void publishEvent(String msg,int status) {
        if (status == 0) {
            ctx.publishEvent(new NotifyEvent(this, msg));
        } else {
            ctx.publishEvent(new NotifyEvent(this, msg));
        }

    }
}
