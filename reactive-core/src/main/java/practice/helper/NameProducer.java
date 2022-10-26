package practice.helper;

import practice.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {
    private FluxSink<String> fluxSink;
    @Override
    public void accept(FluxSink<String> objectFluxSink) {
        this.fluxSink = objectFluxSink;
    }

    public void produce(){
        String name = Util.faker().name().fullName();
        String threadName = Thread.currentThread().getName();
        this.fluxSink.next(threadName+": "+name);
    }

    @Override
    public Consumer<FluxSink<String>> andThen(Consumer<? super FluxSink<String>> after) {
        return Consumer.super.andThen(after);
    }
}
