package com.noam.mcpclientdemo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AiService {
//    String complete(String message);
    Mono<String> complete(String message);
    Flux<String> streamComplete(String message);
}
