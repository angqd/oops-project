package com.example.demo3.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/messages")
public class MessagesControlller {

    private final MessagesService messagesService;
    @Autowired
    public MessagesControlller(MessagesService messagesService) {
        this.messagesService = messagesService;
    }
    @PostMapping(path="/new")
    public void createMessage(@RequestBody AddMessageRequest request){
        messagesService.createMessage(request);
    }
}
