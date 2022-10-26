package practice.operator;

import practice.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class DefaultEmpty {
    public static void main(String[] args) {
        getOrderNumber()
                .filter(i-> i>10)
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumber(){
        return Flux.range(1,10);
                //.delayElements(Duration.ofSeconds(5));  //produce items with delay of 5 seconds
    }
}
