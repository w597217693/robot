package com.bigcat.app;

import com.bigcat.app.config.FileProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.bigcat.app.dao")
@EnableConfigurationProperties({FileProperties.class})
public class RobotAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotAppApplication.class, args);
    }

}
