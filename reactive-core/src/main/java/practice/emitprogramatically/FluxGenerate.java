package practice.emitprogramatically;

import practice.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            //using synchronousSink you are allowed only 1 item to emit
            synchronousSink.next(Util.faker().country().name());
           // synchronousSink.next(Util.faker().country().name()); //comment this to ignore error
            //synchronousSink.complete(); // this print 1 country and complete even take(2)
            synchronousSink.error(new RuntimeException("Run time"));  //same as complete
        }) //generate will run a loop until you will not stop so using - take
                .take(2)
                .subscribe(Util.subscriber());


        //generate country name util country name - canada without take() then exit
        // max emit 10 country then exit
        // if subscriber cancel - exit
        //to check all above 3 condition implementation check - FluxGenerateCounter
        AtomicInteger integer = new AtomicInteger(0);

        Flux.generate(synchronousSink -> {
                    String country = Util.faker().country().name();
                    synchronousSink.next(country);
                    if(country.equalsIgnoreCase("canada")){
                        synchronousSink.complete();
                    }
                    integer.incrementAndGet();
                })
                .subscribe(Util.subscriber());

    }
}
