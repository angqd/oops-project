package com.example.demo3.User.Wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
// wallet is being converted to DTO to prevent some proxy error
@RestController
@RequestMapping(path="/api/v1/wallet")
public class WalletController {
    private final WalletService walletService;
    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }
    /* @GetMapping
      public List<Wallet> getWallets(){
         return walletService.getwallets();
     } */
    @GetMapping
    public List<WalletDTO> getAllWallets() {
        List<Wallet> wallets = walletService.getwallets();
        return wallets.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private WalletDTO convertToDto(Wallet wallet) {
        return new WalletDTO(wallet.getId(), wallet.getBalance(),wallet.getBbuser().getId());
    }
    @PostMapping
    public void addNewWallet(@RequestBody long uid){
        walletService.NewWallet(uid);
    }
}
