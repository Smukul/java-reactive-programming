package practice.operator;

import practice.Util;
import reactor.core.publisher.Flux;

public class CallBacks {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            System.out.println("Inside create ...");
            for (int i=1;i<=5;i++){
                fluxSink.next(i);
            }
            //fluxSink.complete();
            fluxSink.error(new RuntimeException("Runtime exception"));
            System.out.println("Complete ..");
        })
                .doOnComplete(()-> System.out.println("doOnComplete"))
                .doOnNext(o-> System.out.println("doOnNext: "+o))
                .doFirst(()-> System.out.println("doFirst - 1"))
                .doOnSubscribe(o-> System.out.println("doOnSubscribe: "+o))
                .doOnRequest(value -> System.out.println("doOnRequest: "+value))
                .doOnError(err-> System.out.println("doOnError: "+err))
                .doFinally(signalType -> System.out.println("doFinally-1: "+signalType))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doFirst(()-> System.out.println("doFirst - 2"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doOnDiscard(Object.class,o-> System.out.println("doOnDiscard: "+o))
                .take(3)
                .doFirst(()-> System.out.println("doFirst - 3"))
                .doFinally(signalType -> System.out.println("doFinally-2: "+signalType))
                .subscribe(Util.subscriber());

        //execution start bottom to top so doFirst printed 3 / 2 / 1
    }
}
