package practice.emitprogramatically;

import practice.Util;
import practice.helper.NameProducer;
import reactor.core.publisher.Flux;

public class FluxCreateRefactor {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer)
                .subscribe(Util.subscriber("refactor"));

        nameProducer.produce();

        //fluxSink sharing with multiple threads

        Runnable runnable = nameProducer::produce;

        for(int i=0;i<10;i++){
            new Thread(runnable).start();
        }
    }
}
