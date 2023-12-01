package com.example.demo3.Messages;

import java.time.LocalDateTime;

public class AddMessageRequest {
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

    long id;
    long conversationId;
    long senderId;
    long recieverId;
    LocalDateTime timeOfMessage;
    String messageBody;
}
