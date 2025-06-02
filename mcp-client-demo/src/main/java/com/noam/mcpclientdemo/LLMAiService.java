package com.noam.mcpclientdemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LLMAiService implements AiService{

    private final ChatClient chatClient;

    public LLMAiService(ChatClient.Builder builder, ToolCallbackProvider provider) {
        this.chatClient = builder
                .defaultToolCallbacks(provider)
                .defaultAdvisors(
                        MessageChatMemoryAdvisor.builder(
                                MessageWindowChatMemory.builder().build())
                                .build())
                .build();
    }

    @Override
    public Mono<String> complete(String message) {
        // Use .call() which is a synchronous method, but process its result reactively if necessary.
        // Or better yet, use the stream() method from ChatClient for reactive streaming.
        return Mono.fromCallable(() -> this.chatClient.prompt()
                        .user(message)
                        .call()
                        .content())
                .subscribeOn(reactor.core.scheduler.Schedulers.boundedElastic()); // Run blocking call on a different thread pool
    }

//    @Override
//    public String complete(String message) {
//        return this.chatClient.prompt()
//                .user(message)
//                .call()
//                .content();
//    }

    @Override
    public Flux<String> streamComplete(String message) {
        return this.chatClient.prompt()
                .user(message)
                .stream() // This returns a Flux<ChatResponse>
                .content(); // This extracts content as Flux<String>
    }

}

