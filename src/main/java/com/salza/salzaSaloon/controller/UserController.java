package com.salza.salzaSaloon.controller;

import com.salza.salzaSaloon.service.UserService;
import com.salza.salzaSaloon.util.ViewName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("user")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService= userService;
    }

    @GetMapping
    public String getView(Model model){
        if(model == null)
            return ViewName.SIGNUP;
        else

        return ViewName.HOME;


    }


}
