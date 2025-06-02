package com.noam.mcpclientdemo;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ChatController {
    private final AiService aiService;

    public ChatController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/chat/message")
    public Mono<String> sendMessage(@RequestBody String message) {
        return aiService.complete(message);
    }
//    @PostMapping("/chat/message")
//    public String sendMessage(@RequestParam("message") String message) {
//        return aiService.complete(message);
//    }

    @PostMapping(value = "/message/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamMessage(@RequestBody String message) {
        return aiService.streamComplete(message);
    }
}
