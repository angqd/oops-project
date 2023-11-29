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
    // USE THIS FOR THE LOGIN
    //Create new user using email and password only : wallet also created
    @PutMapping("/authUser")
    public Long AuthenticateOrCreateUser(@RequestBody Map<String,String> request){
        String email = request.get("email");
        String name = request.get("name");
        return userService.authOrCreateUser(email,name);
    }

}
