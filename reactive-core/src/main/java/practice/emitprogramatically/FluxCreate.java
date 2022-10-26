package practice.emitprogramatically;

import practice.Util;
import reactor.core.publisher.Flux;

public class FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> { //this is consumer of fluxSink
            /*fluxSink.next(1);
            fluxSink.next(2);
            fluxSink.complete();*/

            /*for (int i=0;i<5;i++){
                fluxSink.next(Util.faker().country().name());
            }
            fluxSink.complete();*/
            String country;
            do{
                country = Util.faker().country().name();
                fluxSink.next(country);
            }while (country.equalsIgnoreCase("India"));

            fluxSink.complete();

        }).subscribe(Util.subscriber());
    }
}
