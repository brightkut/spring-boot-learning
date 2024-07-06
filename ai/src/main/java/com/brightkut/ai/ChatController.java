package com.brightkut.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ai")
@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @PostMapping("/ask-txt")
    String askAIFromText(@RequestBody PromptRequest request) {
        return this.chatClient.prompt()
                .user(request.message())
                .call()
                .content();
    }
}
