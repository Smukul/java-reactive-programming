package practice.mono;

import practice.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class MonoFromFuture {
    public static void main(String[] args) {
        System.out.println("Inside main method");
        String str = Mono.fromFuture(getName())
                //.subscribe(Util.onNext());
                        .block();
        System.out.println(str);
        //Util.sleep(10);
    }

    private static CompletableFuture<String> getName(){
        System.out.println("Inside getName()");
        return CompletableFuture.supplyAsync(()-> Util.faker().name().fullName());
    }
}
