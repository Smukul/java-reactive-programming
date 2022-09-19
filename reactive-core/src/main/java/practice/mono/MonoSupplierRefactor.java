package practice.mono;

import practice.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class MonoSupplierRefactor {
    public static void main(String[] args) {
        getName();
        getName().subscribe(Util.onNext());
        getName();

        //Above why 3rd getName() printing after 2nd . where Async


        //Async flow
        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());
        getName();
        //Needs to block main thread
        Util.sleep(5);


        //Async with block
        getName();
        String result = getName()
                .subscribeOn(Schedulers.boundedElastic())
                        .block();  //it internally block and subscribe the result
        System.out.println(result);
        getName();

    }
    public static Mono<String> getName(){
        System.out.println("Inside getName() >>");
        return Mono.fromSupplier(()->{
            System.out.println("Generating Name ...");
            Util.sleep(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);

    }
}
