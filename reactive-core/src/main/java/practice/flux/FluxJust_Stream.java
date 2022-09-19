package practice.flux;

import practice.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class FluxJust_Stream {
    public static void main(String[] args) {
        //easiest way to create Flux using just
        Flux<Integer> nums = Flux.just(1,2,3);
        nums.subscribe(Util.onNext());

        nums = Flux.empty();
        nums.subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        Flux<Object> objectFlux = Flux.just(1,"a",3,Util.faker().name().firstName());
        objectFlux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        //Flux from Stream
        System.out.println("## Flux From Stream");
        Stream<Integer> stream =  List.of(1,2,4,5,6).stream();

        stream.forEach(System.out::println);
        //stream.forEach(System.out::println);  //stream can not be reused once operated. can not be performed another terminal operation


        Flux<Integer> flux = Flux.fromStream(stream);
        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete()); // same error here as well. stream can not be reused.

        //Create flux using supplier to reuse the stream
        flux = Flux.fromStream(()-> stream);  //passing same reference again stream can not be used

        flux = Flux.fromStream(()-> Stream.of(1,2,4,5,6));
        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
        flux.subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}
