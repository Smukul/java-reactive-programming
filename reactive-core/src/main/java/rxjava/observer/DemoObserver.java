package rxjava.observer;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DemoObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable disposable) {
        System.out.println("thread-"+Thread.currentThread().getName()+"::onSubscribe ---"+disposable.isDisposed());
    }

    @Override
    public void onNext(T o) {
        System.out.println("thread-"+Thread.currentThread().getName()+"::onNext -----"+o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError----"+throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("thread-"+Thread.currentThread().getName()+"::---------onComplete----");
    }
}
