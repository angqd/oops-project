package com.example.demo3.User.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/user/wallet")
public class WalletController {
    private final WalletService walletService;
    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }
    @GetMapping
    public List<Wallet> getWallets(){
        return walletService.getwallets();
    }
    @PostMapping
    public void addNewWallet(@RequestBody long uid){
        walletService.NewWallet(uid);
    }
}
