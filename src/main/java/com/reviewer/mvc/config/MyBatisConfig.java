package com.reviewer.mvc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.reviewer.mvc.model.dao")
public class MyBatisConfig {

}
