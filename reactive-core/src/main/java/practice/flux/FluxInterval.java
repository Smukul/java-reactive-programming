package practice.flux;

import practice.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(0))
                .subscribe(Util.onNext());

        Util.sleep(3);
    }
}
