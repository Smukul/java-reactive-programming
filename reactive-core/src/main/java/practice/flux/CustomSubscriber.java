package practice.flux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import practice.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class CustomSubscriber {
    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(2,10)
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("onSubscribe: "+subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : "+integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : "+throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("OnComplete: Completed");
                    }
                });

        Util.sleep(3);

        atomicReference.get().request(3);
        Util.sleep(3);
        atomicReference.get().request(3);
        Util.sleep(3);
        System.out.println("Cancel the Subscription ---");
        atomicReference.get().cancel();
        Util.sleep(3);
        atomicReference.get().request(3);

        //atomicReference.get().
    }
}
