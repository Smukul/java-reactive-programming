package rxjava.observable;

import io.reactivex.Observable;
import rxjava.observer.DemoObserver;
import rxjava.util.RXUtil;

import java.util.concurrent.TimeUnit;

public class ObservableUsingTimer {
    public static void main(String[] args) {
        Observable.timer(1, TimeUnit.SECONDS)
                .subscribe(new DemoObserver<>());
        RXUtil.sleep(5);
    }
}
