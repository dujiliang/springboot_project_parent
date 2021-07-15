package com.djl.satoken;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.djl.satoken.mapper")
public class SprintbootSatokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintbootSatokenApplication.class, args);
		System.out.println("启动成功：sa-token配置如下：" + SaManager.getConfig());
	}

}
