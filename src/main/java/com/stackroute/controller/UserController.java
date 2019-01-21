package com.stackroute.controller;

import com.stackroute.dao.UserDao;
import com.stackroute.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("login")
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping("showMessage")
    public ModelAndView showMessage(@ModelAttribute("user") User user, ModelAndView modelAndView) throws SQLException {
        modelAndView.setViewName("message");
        modelAndView.addObject("userObject", user);
        userDao.persist(user);
        return modelAndView;
    }
}
