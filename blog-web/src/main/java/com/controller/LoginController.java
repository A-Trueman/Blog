package com.controller;

import com.bo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Lincg on 2017/5/11.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        modelAndView.addObject("username", session.getAttribute("username"));
        return modelAndView;
    }

    @RequestMapping("/user/login.html")
    public ModelAndView login(@RequestBody User user, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        if (userService.login(user.getUsername(), user.getPassword())) {
            session.setAttribute("username", user.getUsername());
            modelAndView.addObject("result","success");
        } else {
            modelAndView.addObject("result", "failed");
        }

        return modelAndView;
    }


    @RequestMapping("/user/register.html")
    @ResponseBody
    public int register(@RequestBody User user) {
        return userService.registerUser(user);
    }
}
