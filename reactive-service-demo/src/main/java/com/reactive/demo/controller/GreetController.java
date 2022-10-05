package com.reactive.demo.controller;

import com.reactive.demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class GreetController {

    @GetMapping("/greet")
    public Mono<Greeting> getGreetings() {
        return computeGreet();
    }

    @GetMapping("/name")
    public Mono<String> getNameFromDb() {
        return getName();
    }
    private Mono<Greeting> computeGreet() {
        return Mono.just(new Greeting("Hello From Rest Controller !!")).delayElement(Duration.ofSeconds(5));
    }
    private Mono<String> getName(){
        return Mono.just("Pratap").delayElement(Duration.ofSeconds(10));
    }
}
