package btvn.session03;

import java.util.ArrayList;
import java.util.List;

public class Baitap05 {
    static record User(String username, String email, String status){
        @Override
        public String toString() {
            return username + " | " + email + " | " + status;
        }
    };

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("alice", "alice@gmail.com", "STATUS"));
        users.add(new User("alexander", "alexander@gmail.com", "INACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "STATUS"));
        users.add(new User("charlotte", "charlotte@gmail.com", "STATUS"));
        users.add(new User("Benjamin", "benjamin@gmail.com", "STATUS"));

        users.stream().sorted((u1, u2) -> {
            return Integer.compare(u2.username.length(), u1.username.length());
        }).limit(3).forEach(System.out::println);

    }
}
