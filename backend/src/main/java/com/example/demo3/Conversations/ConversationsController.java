package com.example.demo3.Conversations;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/conversations")
public class ConversationsController {
private final ConversationsService convosService;

    public ConversationsController(ConversationsService convosService) {
        this.convosService = convosService;
    }

    @PutMapping("/newConvo")
    Long newConversation(@RequestBody Map<String,Long> request){
        long pid = request.get("pid");
        long buyerId = request.get("buyerId");

        return convosService.newConvo(pid,buyerId);
    }
}
