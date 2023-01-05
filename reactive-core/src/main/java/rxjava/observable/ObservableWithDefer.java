package rxjava.observable;

import io.reactivex.Observable;
import rxjava.observer.DemoObserver;
import rxjava.util.RXUtil;

public class ObservableWithDefer {
    public static void main(String[] args) {
        Observable<Integer> integerObservable = Observable.defer(() ->  Observable.fromIterable(RXUtil.positiveIntegers(6)));

        integerObservable.subscribe(new DemoObserver<>());
        System.out.println("Subscribe Again..");

        integerObservable.subscribe(new DemoObserver<>());

    }
}
