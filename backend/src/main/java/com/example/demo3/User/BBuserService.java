package com.example.demo3.User;

import com.example.demo3.Product.Product;
import com.example.demo3.User.Wallet.Wallet;
import com.example.demo3.User.Wallet.WalletRepo;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BBuserService {

    private final BBuserRepo userRepo;
    private final WalletRepo walletRepo;
    @Autowired
    public BBuserService(BBuserRepo userRepo, WalletRepo walletRepo){

        this.userRepo = userRepo;
        this.walletRepo = walletRepo;
    }

    //Get students
    public List<BBuser> getUsers(){
        return userRepo.findAll();
    }


    //POST USER
    @Transactional
    public void addNewUser(BBuser bbuser){
        Optional<BBuser> bbuserOptional = userRepo.findUsersByEmail(bbuser.getEmail());
        if(bbuserOptional.isPresent()){
            throw new IllegalStateException("email already in use ");
        }
        String username = bbuser.getUsername();
        bbuser.setUsername();

        // Create and save a wallet for the user
        Wallet wallet = new Wallet();
        wallet.setBbuser(bbuser);
        walletRepo.save(wallet);
        userRepo.save(bbuser);
    }

    // PUT Name and Email -> creates user or sends id of the user

    public Long authOrCreateUser(String email, String name){
        BBuser existingUser = userRepo.findUsersViaEmail(email);
        if(existingUser!=null){

                return existingUser.getId();
        }else{
            BBuser newUser = new BBuser();
            newUser.setEmail(email);
            newUser.setName(name);
            newUser.setUsername();
            userRepo.save(newUser);


            Wallet wallet = new Wallet();
            wallet.setBbuser(newUser);
            walletRepo.save(wallet);
            userRepo.save(newUser);

            return newUser.getId();
        }
    }


    public void editUser(long id, String name, String hostel, long phoneNumber) {
        BBuser bbuser = userRepo.findBBuserById(id);
        bbuser.setName(name);
        bbuser.setUsername();
        bbuser.setHostel(hostel);
        bbuser.setPhoneNumber(phoneNumber);
        userRepo.save(bbuser);
    }

    public String getUsernameUid(Long id){
        BBuser bbuser = userRepo.findBBuserById(id);
        return bbuser.getUsername();
    }
}
