package practice.hotcoldpublisher;

import practice.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

//Shared Publisher
public class HotPublisher_Share {
    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(HotPublisher_Share::getMovie)
                .delayElements(Duration.ofSeconds(2))
                //using the share method streaming will be shared between users
                        .share(); //convert cold publisher to hot publisher

        // User1 subscribe
        movieStream.subscribe(Util.subscriber("User1"));

        // User2 subscribe after 5 seconds
        Util.sleep(5);
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
