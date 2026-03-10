package btvn.session03;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Baitap04 {
    static record User(String username, String email, String status){}

    public static void main(String[] args) {
        Set<User> users = new HashSet<>();
        users.add(new User("alice", "alice@gmail.com", "STATUS"));
        users.add(new User("bob", "bob@yahoo.com", "INACTIVE"));
        users.add(new User("charlie", "charlie@gmail.com", "STATUS"));
        users.add(new User("alice", "alice2@gmail.com", "STATUS"));
        users.add(new User("bob", "bob@gmail.com", "INACTIVE"));

        Set<User> userSet = new HashSet<>();
        users.forEach((User user) -> {
            Optional<User> userExist = userSet.stream().filter((User u) -> u.username.equals(user.username)).findFirst();
            if(userExist.isEmpty()){
                userSet.add(user);
            }
        });

        userSet.forEach(System.out::println);
    }
}
