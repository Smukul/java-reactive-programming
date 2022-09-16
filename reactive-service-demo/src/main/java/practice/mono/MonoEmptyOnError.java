package practice.mono;

import practice.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyOnError {

    public static void main(String[] args) {
        userRepository(4)
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }

    private static Mono<String> userRepository(int userId){
        Mono<String> mono;
        if(userId == 1){
           mono= Mono.just(Util.faker().name().firstName());
        } else if (userId ==2) {
            mono= Mono.empty();
        } else {
            mono = Mono.error(new RuntimeException("User ID is not valid."));
        }

        return mono;
    }

}
