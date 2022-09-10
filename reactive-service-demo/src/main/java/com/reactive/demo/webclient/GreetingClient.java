package com.reactive.demo.webclient;

import com.reactive.demo.model.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class GreetingClient {
    @Value("app.base.url")
    private String baseUrl;
    private final WebClient webClient;
    // Spring Boot autoconfigures a `WebClient.Builder` instance with nice defaults and customizations.
    // We can use it to create a dedicated `WebClient` for our component.
    public GreetingClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl(baseUrl).build();
    }

    public Mono<String> getMessage() {
        return this.webClient.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Greeting.class)
                .map(Greeting::getMessage);
    }
}
