package com.example.demo3.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/user")
public class BBuserController {
    private final BBuserService userService;
    @Autowired
    public BBuserController(BBuserService userService) {
        this.userService = userService;
    }
   @GetMapping
    public List<BBuser> getUsers(){
        return userService.getUsers();
    }
    @PostMapping
    public void addNewUser(@RequestBody BBuser bbuser){
        userService.addNewUser(bbuser);
    }
    @GetMapping("/createUserWithProduct")
    public String createUserWithProduct() {
        userService.addUserWithProduct();
        return "User created with associated product!";
    }

}
