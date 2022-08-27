package com.ecommerce.user.controller;

import com.ecommerce.user.VO.UserBean;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserBean findUserById(@PathVariable("id") Long userId){
        return userService.findUserById(userId);
    }
}
