package practice.operator;

import practice.Util;
import reactor.core.publisher.Flux;

public class LimitRate {
    public static void main(String[] args) {
        //limit rate - control the flow of number of items

        Flux.range(1,1000)  //separated thread
                .log()
                //.limitRate(100)  //as when 75% items are emitted first then it will request for another 75%
                .limitRate(100,99) //customise 75% to 99%.
                .subscribe(Util.subscriber());  ////separated thread
    }
}
