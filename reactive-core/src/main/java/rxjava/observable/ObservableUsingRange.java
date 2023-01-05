package rxjava.observable;

import io.reactivex.Observable;
import rxjava.observer.DemoObserver;

public class ObservableUsingRange {
    public static void main(String[] args) {
        Observable.range(1,6)
                .subscribe(new DemoObserver<>());
    }
}
