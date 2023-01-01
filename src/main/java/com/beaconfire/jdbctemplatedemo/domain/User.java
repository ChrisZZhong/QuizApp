package com.beaconfire.jdbctemplatedemo.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    private int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNumber;
    private String email;
    private Boolean isActive;
    private Boolean isAdmin;

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    };
}
