package rxjava.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import rxjava.observer.DemoObserver;
import rxjava.util.RXUtil;
import rxjava.util.Shape;

import java.util.List;

public class ObservableUsingCreate {
    public static void main(String[] args) {
        List<Shape> shapes = RXUtil.getShapes(5);

        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                try {
                    shapes.forEach(observableEmitter::onNext);
                } catch (Exception e){
                    System.err.println("Exception -- "+e.getMessage());
                }
                observableEmitter.onComplete();
            }
        }).subscribe(new DemoObserver<>());
    }
}
