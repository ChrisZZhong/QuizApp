package com.beaconfire.jdbctemplatedemo.dao;
import com.beaconfire.jdbctemplatedemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {

    JdbcTemplate jdbcTemplate;

    UserRowMapper userRowMapper;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    public void createNewUser(User user) {
        String query = "insert into user (username, password, first_name, last_name, address, phone_number, email, is_active, is_admin) values (?, ?, ?, ?, ?, ?, ?, 1, 0)";
        jdbcTemplate.update(query,
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getEmail());
    }

    public List<User> getAllUsers() {
        String query = "select * from user";
        List<User> users = jdbcTemplate.query(query, userRowMapper);
        return users;
    }

}
