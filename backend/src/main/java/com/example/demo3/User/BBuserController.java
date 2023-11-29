package com.example.demo3.User;

import com.example.demo3.User.Wallet.WalletController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/v1/user")
public class BBuserController {


    private final BBuserService userService;


    @Autowired
    public BBuserController(BBuserService userService, WalletController walletController) {
        this.userService = userService;
    }

   @GetMapping
    public List<BBuser> getUsers(){
        return userService.getUsers();
    }
    // addNewUser Function  used in SignUp
    @PostMapping
    public void addNewUser(@RequestBody BBuser bbuser){
        userService.addNewUser(bbuser);
    }
    @PutMapping(path = "/getid")
    public Long GetUid(@RequestBody Map<String, String> request){
        String username = request.get("username");
        String password = request.get("password");
        return userService.authandgetUid(username,password);
    }

}
