package com.kong.king.spring.exam01.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam01")
public class Exam01Controller {
    private final userDAO dao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public Exam01Controller(userDAO dao) {
        this.dao = dao;
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute user user, Model m) {
        try {
            dao.adduser(user);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("에러");
            m.addAttribute("error", "에러");
        }
        return "redirect:/exam01/userList";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello5")
    public String hello5() {
        return "hello5";
    }

    @GetMapping("/userList")
    public String getuserList(Model m) {
        try {
            List<user> userList = dao.getAll();
            m.addAttribute("userList", userList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("에러");
            m.addAttribute("error", "에러");
        }
        return "user/userList";
    }
}
