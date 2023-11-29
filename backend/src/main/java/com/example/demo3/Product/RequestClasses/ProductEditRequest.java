package com.example.demo3.Product.RequestClasses;

public class ProductEditRequest {

    public ProductEditRequest(long id, double currentBid, long buyerId) {
        this.id = id;
        this.currentBid = currentBid;
        this.buyerId = buyerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerId) {
        this.buyerId = buyerId;
    }

    private long id;
    private double currentBid;
    private long buyerId;

}
