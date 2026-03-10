package btvn.session03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Baitap03 {
    // Sử dụng record User từ bài 1
    static List<Baitap01.User> users = new ArrayList<>() ;
    static Optional<Baitap01.User> findUserByUsername(String username){
        return users.stream().filter((Baitap01.User u) -> u.username().equals(username)).findFirst() ;
    };

    public static void main(String[] args) {
        users.add(new Baitap01.User("alice", "alice@gmail.com", "STATUS"));
        users.add(new Baitap01.User("bob", "bob@yahoo.com", "INACTIVE"));
        users.add(new Baitap01.User("charlie", "charlie@gmail.com", "STATUS"));

        Optional<Baitap01.User> result = findUserByUsername("alice");
        if(result.isEmpty()){
            System.out.println("Quest login");
        }else{
            System.out.println("Welcome alice");
        }

    }
}
