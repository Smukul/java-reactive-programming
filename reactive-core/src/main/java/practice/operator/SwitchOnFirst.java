package practice.operator;

import practice.Util;
import practice.helper.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class SwitchOnFirst {
    public static void main(String[] args) {
        getPerson()
                .switchOnFirst((signal, personFlux) -> {
                    System.out.println("Inside switchOnFirst ...");
                    return signal.isOnNext() && signal.get().getAge()>15?personFlux:applyFilterMap().apply(personFlux);
                })

                .subscribe(Util.subscriber());
    }

    private static Flux<Person> getPerson(){
        return Flux.range(1,10)
                .map(i-> new Person());
    }

    private static Function<Flux<Person>,Flux<Person>> applyFilterMap(){
        return personFlux -> personFlux
                .filter(p-> p.getAge()>15)
                .doOnNext(i-> i.setName(i.getName().toUpperCase()))
                .doOnDiscard(Person.class,person -> System.out.println("Filtered - "+person));
    }
}
