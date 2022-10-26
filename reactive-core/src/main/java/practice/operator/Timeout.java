package practice.operator;

import practice.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Timeout {
    public static void main(String[] args) {
        getOrderNumber()
               // .timeout(Duration.ofSeconds(2)) //if item is not received withing 2 seconds then timeout and produce error
                .timeout(Duration.ofSeconds(2),fallback())  //timeout with fallback
                .subscribe(Util.subscriber());

        Util.sleep(50);
    }

    private static Flux<Integer> getOrderNumber(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(5));  //produce items with delay of 5 seconds
    }

    private static Flux<Integer> fallback(){
        return Flux.range(1,10)
                .delayElements(Duration.ofMillis(100));
    }
}
