package com.beaconfire.jdbctemplatedemo.controller;

import com.beaconfire.jdbctemplatedemo.domain.User;
import com.beaconfire.jdbctemplatedemo.service.LoginService;
import com.beaconfire.jdbctemplatedemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.beaconfire.jdbctemplatedemo.dao.UserRowMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {
    private final LoginService loginService;

    private final UserService userService;

    private final UserRowMapper userRowMapper;

    public LoginController(LoginService loginService, UserService userService, UserRowMapper userRowMapper) {
        this.loginService = loginService;
        this.userService = userService;
        this.userRowMapper = userRowMapper;
    }

    @GetMapping("/login")
    public ModelAndView getLogin(HttpServletRequest request) {
        System.out.println("get login");
        HttpSession session = request.getSession(false);

//         redirect to /quiz if user is already logged in
        if (session != null && session.getAttribute("user") != null) {
            return new ModelAndView("redirect:/quiz");
        }

        return new ModelAndView("login");
    }

    // validate that we are always getting a new session after login
    @PostMapping("/login")
    public ModelAndView postLogin(@RequestParam String username,
                            @RequestParam String password,
                            HttpServletRequest request) {

        Optional<User> possibleUser = loginService.validateLogin(username, password);
        System.out.println("post login");
        if(possibleUser.isPresent()) {
            HttpSession oldSession = request.getSession(false);
            // invalidate old session if it exists
            if (oldSession != null) oldSession.invalidate();

            // generate new session
            HttpSession newSession = request.getSession(true);

            // store user details in session
            newSession.setAttribute("user", possibleUser.get());

            return new ModelAndView("redirect:/quiz");
        } else { // if user details are invalid
            return new ModelAndView("login");
        }
    }

    @GetMapping("/signup")
    public ModelAndView getSignup(HttpServletRequest request) {
        return new ModelAndView("signup");
    }

    @PostMapping("/signup")
    public ModelAndView postSignup(HttpServletRequest request) {
        User user = userRowMapper.mapRequestRow(request);
        userService.createNewUser(user);
        return new ModelAndView("/login");

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        HttpSession oldSession = request.getSession(false);
        // invalidate old session if it exists
        if(oldSession != null) oldSession.invalidate();
        return "login";
    }
}
