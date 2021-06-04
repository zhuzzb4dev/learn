package com.mo.persist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.mo.persist.dao"})
public class PersistApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersistApplication.class, args);
    }

}
