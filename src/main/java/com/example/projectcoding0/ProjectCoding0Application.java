package com.example.projectcoding0;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.example.projectcoding0.mapper")  // 自动扫描 mapper 包
public class ProjectCoding0Application {

    public static void main(String[] args) {
        SpringApplication.run(ProjectCoding0Application.class, args);
    }

}

