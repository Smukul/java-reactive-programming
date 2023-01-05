package rxjava.observable;

import io.reactivex.Observable;
import rxjava.observer.DemoObserver;
import rxjava.util.RXUtil;

import java.util.concurrent.TimeUnit;

public class ObservableUsingInterval {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new DemoObserver<>());

        RXUtil.sleep(6);
    }
}
