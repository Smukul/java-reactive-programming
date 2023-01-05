package rxjava.observable;

import com.github.javafaker.IdNumber;
import io.reactivex.Observable;
import rxjava.observer.DemoObserver;
import rxjava.util.RXUtil;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class ObservableUsingCallable {
    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "From Callable";
            }
        };


        Observable.fromCallable(callable).subscribe(new DemoObserver<>());
    }
}
