package com.example.demo3.User.Wallet;
// new class created to prevent some hibernate proxy error
public class WalletDTO {
    private long id;
    private double balance;



    private long uid;

    public WalletDTO() {
    }

    public WalletDTO(long id, double balance,long uid) {
        this.id = id;
        this.balance = balance;
        this.uid = uid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }
}
