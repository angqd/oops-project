package com.example.demo3.User.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {
    private final WalletRepo walletRepo;
    @Autowired
    public WalletService(WalletRepo walletRepo) {
        this.walletRepo = walletRepo;
    }
    //create waller when user is created
    public void NewWallet(long uid){
        Wallet wallet =  new Wallet();
        wallet.setId(uid);
        walletRepo.save(wallet);
    }

    public List<Wallet> getwallets() {
        return walletRepo.findAll();
    }
}
