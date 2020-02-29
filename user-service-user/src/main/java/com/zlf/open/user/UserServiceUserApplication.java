package com.zlf.open.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("${dubbo.config.location}")
public class UserServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceUserApplication.class, args);
    }

}
