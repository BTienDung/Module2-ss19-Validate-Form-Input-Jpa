package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/list");
        Iterable<User> userIterable = userService.findAll();
        modelAndView.addObject("users", userIterable);
        return modelAndView;
    }
    @GetMapping("/form-create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create-user")
    public ModelAndView createUser(@Valid @ModelAttribute User user, BindingResult bindingResult){

        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("/create");
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("/list");
            userService.save(user);
            return modelAndView;
        }
    }
}
