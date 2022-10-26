package practice.operator;

import practice.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Delay {
    public static void main(String[] args) {
        //delay - delayElements

        System.setProperty("reactor.bufferSize.x","10");

        Flux.range(1,100)  //first only 32 items are requested but who requested 32 because of delayElements
                //not handled in below code-this is default behaviour - to change this set property reactor.bufferSize.x
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());

        Util.sleep(50);
    }
}
