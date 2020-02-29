package com.zlf.user.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("${dubbo.config.location}")
public class UserServiceCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceCoreApplication.class, args);
    }

}
