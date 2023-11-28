package com.example.demo3.User;

import com.example.demo3.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BBuserService {

    private final BBuserRepo userRepo;
    @Autowired
    public BBuserService(BBuserRepo userRepo){
        this.userRepo = userRepo;
    }

    //Get students
    public List<BBuser> getUsers(){
        return userRepo.findAll();
    }


    //post user
    public void addNewUser(BBuser bbuser){
        Optional<BBuser> bbuserOptional = userRepo.findUsersByEmail(bbuser.getEmail());
        if(bbuserOptional.isPresent()){
            throw new IllegalStateException("email already in use ");
        }
        userRepo.save(bbuser);
    }
    // new user plus product
    public void addUserWithProduct(){
        BBuser bbuser = new BBuser("John Doe", "john.doe@example.com", 123456789);
        Product product = new Product("Light Bulb", "A bright light source", LocalDateTime.now());
        bbuser.addUserProduct(product);
        userRepo.save(bbuser);
    }

}
