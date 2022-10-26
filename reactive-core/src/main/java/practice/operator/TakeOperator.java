package practice.operator;

import practice.Util;
import reactor.core.publisher.Flux;

public class TakeOperator {
    public static void main(String[] args) {
        //Operators <> decorators - map, filter, log

        Flux.range(1,10)
                .log()
                .take(3)  //cancel the subscription after 3 items
                .log()
                .subscribe(Util.subscriber());
    }
}
