package com.example.demo3.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesService {
    private final MessagesRepo messagesRepo;
    @Autowired

    public MessagesService(MessagesRepo messagesRepo) {

        this.messagesRepo = messagesRepo;
    }
    public void createMessage(AddMessageRequest request){
        Messages newMessage = new Messages(
                request.getConversationId(),
                request.getSenderId(),
                request.getRecieverId(),
                request.getTimeOfMessage(),
                request.getMessageBody()
        );
        messagesRepo.save(newMessage);
    }
}
