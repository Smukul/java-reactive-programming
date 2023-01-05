package rxjava.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import rxjava.observer.DemoObserver;

public class ObservableJust {
    public static void main(String[] args) {
        Observable.just("a","b","c","d")
                .subscribe(new DemoObserver<>());
    }
}
