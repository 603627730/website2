package com.example.website2;

import com.example.website2.generator.mapper.LiBrandMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan("com.baomidou.mybatisplus.core.mapper")
public class Website2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Website2Application.class, args);
        LiBrandMapper bean = run.getBean(LiBrandMapper.class);
        System.out.println(bean);
    }

}
