package practice.flux;

import practice.Util;
import reactor.core.publisher.Flux;

public class FluxRange_Log {
    public static void main(String[] args) {
        System.out.println(3/-1);


        // Flux.never() > this will not give any signal or data

        Flux.range(5, 5)
                .log()
                .map(i -> Util.faker().name().fullName())
                .subscribe(Util.onNext());
    }
}
