package practice.mono;

import practice.Util;
import reactor.core.publisher.Mono;

public class MonoExample {
    public static void main(String[] args) {
        Mono<Integer> empty = Mono.empty();
        empty.subscribe(Util.onNext(),Util.onError(),Util.onComplete());  //OnComplete signal will receive first

        Mono<Integer> error = Mono.error(new RuntimeException("Test mono error"));
        error.subscribe(Util.onNext(),Util.onError(),Util.onComplete());  //OnError signal will receive first

       handleError();
    }

    public static void handleError(){
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l/0);

        //1 call the mono
        //mono.subscribe();

        //2 call the mono as well
        mono.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}
