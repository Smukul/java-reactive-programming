package practice.flux;

import practice.Util;
import practice.flux.helper.NameGenerator;
import reactor.core.publisher.Flux;

import java.util.List;

public class FluxVsList {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<String> names = NameGenerator.getNames(5);
        System.out.println(names);
        long end = System.currentTimeMillis();
        System.out.println("Total time taken: "+(end-start));


        System.out.println("Get name using Flux");
        start = System.currentTimeMillis();
        Flux<String> namesFlux = NameGenerator.getNamesFlux(5);
        namesFlux.subscribe(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("Total time taken by flux: "+(end-start));
    }
}
