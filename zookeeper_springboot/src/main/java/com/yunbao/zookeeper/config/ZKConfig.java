package com.yunbao.zookeeper.config;

import com.yunbao.zookeeper.demo.ZKCurator;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: djl
 * @Date: 2020/5/27 15:00
 * @Version 1.0
 */
@Configuration
public class ZKConfig {

    @Bean(initMethod = "start")
    public CuratorFramework client() {
        CuratorFramework client = CuratorFrameworkFactory
                .newClient("127.0.0.1:2181", 10000, 5000, retryPolicy());
        return client;
    }


    @Bean
    public RetryNTimes retryPolicy() {
        return new RetryNTimes(10, 5000);
    }

    @Bean
    public ZKCurator zkCurator() {
        ZKCurator zkCurator = new ZKCurator(client());
        return zkCurator;
    }
}
