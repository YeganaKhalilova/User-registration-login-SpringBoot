package com.example.userloginregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UserloginregistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserloginregistrationApplication.class, args);
    }

}
