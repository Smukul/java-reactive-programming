package practice.emitprogramatically;

import practice.Util;
import reactor.core.publisher.Flux;

public class FluxGenerateCounter {
    public static void main(String[] args) {
        //generate country name util country name - canada without take() then exit
        // max emit 10 country then exit
        // if subscriber cancel - exit
        Flux.generate(
                ()-> 1,
                (counter,sink)-> {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if(counter>=10 || country.equalsIgnoreCase("canada")){
                        sink.complete();
                    }
                    return counter+1;
                    }
        )
                .take(4)
                .subscribe(Util.subscriber());
    }
}
