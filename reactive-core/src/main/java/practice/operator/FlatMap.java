package practice.operator;

import practice.Util;
import practice.helper.User;
import reactor.core.publisher.Flux;

public class FlatMap {
    public static void main(String[] args) {
        Flux<User> users = UserService.getUsers();

        users
               // .map(user -> OrderServer.getOrders(user.getUserId()))  //this will return Flux object
                .flatMap(user -> OrderServer.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());
    }
}
