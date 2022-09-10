package com.reactive.demo.controller;

import com.reactive.demo.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GreetController {

    @GetMapping("/greet")
    public Mono<Greeting> getGreetings(){
        return Mono.just(new Greeting("Hello From Rest Controller !!"));
    }
}
