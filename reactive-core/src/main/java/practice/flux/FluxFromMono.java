package practice.flux;

import practice.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        doSomething(Flux.from(mono)); // create flux form mono or any publisher

        //convert mono from flux
        System.out.println("Mono from Flux");
        Flux.range(0,5)
                .filter(i -> i>3)
                .next()  //very first item given by this as mono
                .subscribe(Util.onNext());
    }

    private static void doSomething(Flux<String> flux){
        flux.subscribe(Util.onNext());
    }
}
