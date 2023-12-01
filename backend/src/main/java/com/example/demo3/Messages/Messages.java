package com.example.demo3.Messages;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="messages_table")
public class Messages {
    @Id
    @SequenceGenerator(
            name = "messages_sequence",
            sequenceName = "messages_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "messages_sequence"
    )
    long id;
    long conversationId;
    long senderId;
    long recieverId;
    LocalDateTime timeOfMessage;
    String messageBody;

    public Messages() {
    }

    public Messages(long id, long conversationId, long senderId, long recieverId, LocalDateTime timeOfMessage, String messageBody) {
        this.id = id;
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.timeOfMessage = timeOfMessage;
        this.messageBody = messageBody;
    }

    public Messages(long conversationId, long senderId, long recieverId, LocalDateTime timeOfMessage, String messageBody) {
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.recieverId = recieverId;
        this.timeOfMessage = timeOfMessage;
        this.messageBody = messageBody;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getConversationId() {
        return conversationId;
    }

    public void setConversationId(long conversationId) {
        this.conversationId = conversationId;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(long recieverId) {
        this.recieverId = recieverId;
    }

    public LocalDateTime getTimeOfMessage() {
        return timeOfMessage;
    }

    public void setTimeOfMessage(LocalDateTime timeOfMessage) {
        this.timeOfMessage = timeOfMessage;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
