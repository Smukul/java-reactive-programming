package practice.emitprogramatically;

import practice.Util;
import reactor.core.publisher.Flux;

public class FluxCreateIssueFix {
    public static void main(String[] args) {
        //generate country name util country name - canada without take() then exit
        // max emit 10 country then exit
        // if subscriber cancel - exit
        Flux.create(fluxSink -> { //this is consumer of fluxSink
            int counter=0;
            String country;
            do{
                country = Util.faker().country().name();
                System.out.println("Emitting Country: "+country );
                fluxSink.next(country);
                counter++;
            }while (country.equalsIgnoreCase("canada") && !fluxSink.isCancelled() && counter<10);

            fluxSink.complete();

        })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
