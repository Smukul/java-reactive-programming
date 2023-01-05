package practice.hotcoldpublisher;

import practice.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

//Shared Publisher
public class HotPublisher_AutoConnect {
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(HotPublisher_AutoConnect::getMovie)
                .delayElements(Duration.ofSeconds(1))
                //cache = publish().replay()
                        .cache();

        // User1 subscribe
        movieStream.subscribe(Util.subscriber("User1"));

        // User2 subscribe after 15 seconds
        // at this time user1 has completed and when user2 subscribe that time streaming is finished
        // scene will not delay and published all same time for user2

        Util.sleep(10);
        System.out.println("User2 about to join ...");
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
