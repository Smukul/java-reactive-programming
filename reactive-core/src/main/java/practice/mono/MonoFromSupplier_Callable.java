package practice.mono;

import practice.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class MonoFromSupplier_Callable {
    public static void main(String[] args) {
        //Use just() - only when data is ready
        //Mono<String> mono = Mono.just(getName());

        Mono<String> mono = Mono.fromSupplier(MonoFromSupplier_Callable::getName);
        mono.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        //Mono from Callable
        Callable<String> stringCallable = MonoFromSupplier_Callable::getName;
        Mono.fromCallable(stringCallable)
                .subscribe(Util.onNext());



    }

    public static String getName(){
        System.out.println("Generating Name ...");
        return Util.faker().name().fullName();
    }
}
