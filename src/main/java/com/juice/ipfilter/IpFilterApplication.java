package com.juice.ipfilter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.juice.ipfilter.dao")
public class IpFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpFilterApplication.class, args);
    }

}

