package practice.mono;

import practice.Util;
import reactor.core.publisher.Mono;

import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;

public class MonoFromRunnable {
    public static void main(String[] args) {
        Runnable runnable = ()-> System.out.println("Runnable");

        Mono.fromRunnable(runnable)
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
        Util.sleep(2);

        Mono.fromRunnable(anyProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        ()->{
                            System.out.println("Mono Runnable completed");
                        });
    }

    private static Runnable anyProcess(){
        return ()->{
            Util.sleep(3);
            System.out.println("Operation Completed.");
        };
    }
}
