package com.ysynzehao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
/**
 * spring boot 启动类
 * @author Administrator
 *
 */
@SpringBootApplication
@ImportResource(value = {"classpath:consumers.xml"}) // 使用 consumers.xml 配置；  
public class SpringTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}
}
