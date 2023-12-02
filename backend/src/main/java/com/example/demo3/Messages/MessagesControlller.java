package com.example.demo3.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @PostMapping(path = "/getConvoMessages")
    public List<Messages> getAllMessagesFromConvo(@RequestBody Map<String,Long> request){
        long cid = request.get("conversationId");
        return messagesService.getMfromC(cid);
    }

}
