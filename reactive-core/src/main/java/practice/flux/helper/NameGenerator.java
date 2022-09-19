package practice.flux.helper;

import practice.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNames(int count){
        List<String> names = new ArrayList<>(count);
        for(int i=0;i<count;i++){
            names.add(getName());
        }
        return names;
    }

    public static Flux<String> getNamesFlux(int count){
        return Flux.range(0,count)
                .map(i -> getName());
    }

    private static String getName(){
        Util.sleep(3);
        return Util.faker().name().fullName();
    }
}
