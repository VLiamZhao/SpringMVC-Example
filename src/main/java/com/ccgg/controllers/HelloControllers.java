package com.ccgg.controllers;

import com.ccgg.beans.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloControllers {
    @Autowired
    private Person person;

    @RequestMapping("/hello")
    public ModelAndView sayHello (HttpServletRequest request) {
        String name = request.getParameter("name");
        System.out.println(name);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("hello");
        mav.addObject("title", "hello " + name + "Welcome to Spring MVC");
        return mav;
    }

    @RequestMapping("/main")
    public String goMain(ModelMap model, HttpSession session) {
        model.addAttribute("msg", "This is message.");
        session.setAttribute("welcome", "Welcome from session");
        return "mainpage";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return "This is data!";
    }

    @RequestMapping("/person")
    @ResponseBody
    public Person getPerson() {
        return person;
    }
}
