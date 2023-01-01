package com.beaconfire.jdbctemplatedemo.dao;

import com.beaconfire.jdbctemplatedemo.domain.User;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setAddress(rs.getString("address"));
        user.setPhoneNumber(rs.getInt("phone_number"));
        user.setEmail(rs.getString("email"));
        user.setIsActive(rs.getBoolean("is_active"));
        user.setIsAdmin(rs.getBoolean("is_admin"));
        return user;
    }

    public User mapRequestRow(HttpServletRequest request) {
        User user = User.builder()
                .username(request.getParameter("username"))
                .password(request.getParameter("password"))
                .firstName(request.getParameter("firstName"))
                .lastName(request.getParameter("lastName"))
                .phoneNumber(Integer.parseInt(request.getParameter("phoneNumber")))
                .email(request.getParameter("email"))
                .address(request.getParameter("address"))
                .build();
        return user;
    }

}
