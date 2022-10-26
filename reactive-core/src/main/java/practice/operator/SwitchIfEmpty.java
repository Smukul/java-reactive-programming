package practice.operator;

import practice.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumber()
                .filter(i-> i>10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());

        Util.sleep(20);
    }

    private static Flux<Integer> getOrderNumber(){
        return Flux.range(1,10);
                //.delayElements(Duration.ofSeconds(5));  //produce items with delay of 5 seconds
    }

    private static Flux<Integer> fallback(){
        return Flux.range(100,10)
                .delayElements(Duration.ofMillis(100));
    }
}
