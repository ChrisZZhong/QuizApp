package com.beaconfire.jdbctemplatedemo;

import com.beaconfire.jdbctemplatedemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcTemplateDemoApplication {

    private static UserDao userDao;

    @Autowired
    public JdbcTemplateDemoApplication(UserDao userDao) {
        this.userDao = userDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcTemplateDemoApplication.class, args);

        System.out.println("The number of user is: " + userDao.getAllUsers());

    }



}
