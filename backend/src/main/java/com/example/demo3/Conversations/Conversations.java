package com.example.demo3.Conversations;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "conversations_table")
public class Conversations {


    @Id
    @SequenceGenerator(
            name = "conversations_sequence",
            sequenceName = "conversations_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "conversations_sequence"
    )
    private long id;
    private long pid;
    private long sellid;
    private long buyerId;
    private LocalDateTime timeOfLastMessage;
    private  long senderOfLastMessage;

    public Conversations() {
    }

    public Conversations(long id, long pid, long sellid, long buyerId, LocalDateTime timeOfLastMessage, long senderOfLastMessage) {
        this.id = id;
        this.pid = pid;
        this.sellid = sellid;
        this.buyerId = buyerId;
        this.timeOfLastMessage = timeOfLastMessage;
        this.senderOfLastMessage = senderOfLastMessage;
    }

    public Conversations(long pid, long sellid, long buyerId, LocalDateTime timeOfLastMessage) {
        this.pid = pid;
        this.sellid = sellid;
        this.buyerId = buyerId;
        this.timeOfLastMessage = timeOfLastMessage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public long getSellid() {
        return sellid;
    }

    public void setSellid(long sellid) {
        this.sellid = sellid;
    }

    public long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(long buyerid) {
        this.buyerId = buyerid;
    }

    public LocalDateTime getTimeOfLastMessage() {
        return timeOfLastMessage;
    }

    public void setTimeOfLastMessage(LocalDateTime timeOfLastMessage) {
        this.timeOfLastMessage = timeOfLastMessage;
    }

    public long getSenderOfLastMessage() {
        return senderOfLastMessage;
    }

    public void setSenderOfLastMessage(long senderOfLastMessage) {
        this.senderOfLastMessage = senderOfLastMessage;
    }

}
