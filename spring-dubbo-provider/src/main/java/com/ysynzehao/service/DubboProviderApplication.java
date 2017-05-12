package com.ysynzehao.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication  
@ImportResource(value = {"classpath:providers.xml"}) // 使用 providers.xml 配置；  
@EnableJpaRepositories("com.ysynzehao.dao")
@EntityScan("com.ysynzehao.entry")
@ComponentScan(basePackages={"com.ysynzehao"})
public class DubboProviderApplication {  
    public static void main(String[] args) {  
        SpringApplication.run(DubboProviderApplication.class, args);  
    }  
}  