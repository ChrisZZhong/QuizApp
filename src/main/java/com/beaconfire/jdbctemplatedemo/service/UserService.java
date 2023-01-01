package com.beaconfire.jdbctemplatedemo.service;

import com.beaconfire.jdbctemplatedemo.dao.UserDao;
import com.beaconfire.jdbctemplatedemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) { this.userDao = userDao; }

    public void createNewUser(User user) {
        userDao.createNewUser(user);
    }
//
//    public List<User> getAllUsers() {
//        return userDao.getAllUsers();
//    }
//
//    public User getUserById(int id) {
//        return userDao.getAllUsers().stream()
//                .filter(a -> a.getUserId() == id)
//                .findFirst()
//                .orElse(new User(-1, "invalid username", "invalid password"));
//    }

    public Optional<User> validateLogin(String username, String password) {
        return userDao.getAllUsers().stream()
                .filter(a -> a.getUsername().equals(username)
                        && a.getPassword().equals(password))
                .findAny();
    }

}
