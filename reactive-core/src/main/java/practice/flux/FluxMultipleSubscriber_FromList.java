package practice.flux;

import practice.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxMultipleSubscriber_FromList {
    public static void main(String[] args) {
        Flux<Integer> publisher = Flux.just(1,2,3,4,6,7,8);

        publisher.
        filter(i -> i%2 == 0)
                .subscribe(n -> System.out.println("Even Subs 1 - "+n));
        publisher.subscribe(n -> System.out.println("Subs 2 - "+n));

        //Flux from Array / List
        List<String> list = Arrays.asList("a","b","c");
        Flux.fromIterable(list)
                .subscribe(Util.onNext());

        Integer[] nums = new Integer[]{2,7,8,9};
        Flux.fromArray(nums)
                .subscribe(Util.onNext());

    }
}
