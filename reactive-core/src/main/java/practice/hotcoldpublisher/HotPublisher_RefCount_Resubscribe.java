package practice.hotcoldpublisher;

import practice.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

//Shared Publisher
public class HotPublisher_RefCount_Resubscribe {
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(HotPublisher_RefCount_Resubscribe::getMovie)
                .delayElements(Duration.ofSeconds(1))
                // share = publish.recount(1)
                        .publish()
                                .refCount(1);

        // User1 subscribe
        movieStream.subscribe(Util.subscriber("User1"));

        // User2 subscribe after 15 seconds
        // at this time user1 has completed and when user2 subscribe that time min-subscriber is 1
        // it will start emitting data and work like cold publisher for user1 and user2

        Util.sleep(15);
        movieStream.subscribe(Util.subscriber("User2"));

        Util.sleep(60);
    }

    private static Stream<String> getMovie(){
        return Stream.of(
                "Scene-1",
                "Scene-2",
                "Scene-3",
                "Scene-4",
                "Scene-5",
                "Scene-6"
        );
    }
}
