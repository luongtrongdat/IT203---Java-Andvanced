package btvn.session03;

import java.util.ArrayList;
import java.util.List;

public class Baitap02 {
    public record User(String username, String email, String status){
        @Override
        public String toString() {
            return username;
        }
    };

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("alice", "alice@gmail.com", "STATUS"));
        users.add(new User("bob", "bob@yahoo.com", "INACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "STATUS"));

        users.stream().filter(( user) -> user.email.endsWith("gmail.com")).forEach(System.out::println);
    }
}
