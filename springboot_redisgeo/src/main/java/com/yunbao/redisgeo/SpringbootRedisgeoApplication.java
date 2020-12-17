package com.yunbao.redisgeo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yunbao.redisgeo.mapper")
public class SpringbootRedisgeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRedisgeoApplication.class, args);
	}

}
