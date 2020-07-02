package com.aaa.zyf;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.aaa.zyf.dao"})
public class zyfApplication {
    public static void main(String[] args) {
        SpringApplication.run(zyfApplication.class,args);
    }
}
