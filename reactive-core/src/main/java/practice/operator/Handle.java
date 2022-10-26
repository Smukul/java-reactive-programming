package practice.operator;

import practice.Util;
import reactor.core.publisher.Flux;

public class Handle {
    public static void main(String[] args) {
        //handle = filter + map

        Flux.range(1,10)
                .handle((integer,synchronousSink)->{
                   // synchronousSink.next(integer); //all items
                    /*if(integer%2 ==0)
                        synchronousSink.next(integer); //only even  - filter
                    else synchronousSink.next(integer+" a");  // map
*/
                    if(integer ==7)
                        synchronousSink.complete();   //only 7 take
                    else synchronousSink.next(integer+" a");  // map

                }).subscribe(Util.subscriber());



        //generate country name util country name - canada without take() then exit

        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle(((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if(s.equalsIgnoreCase("canada"))
                        synchronousSink.complete();
                }))
                .subscribe(Util.subscriber());


    }
}
