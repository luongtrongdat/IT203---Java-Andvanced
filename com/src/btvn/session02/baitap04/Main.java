package btvn.session02.baitap04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Nguyen Van A", 20, "Nam"));
        userList.add(new User("Nguyen Van A", 20, "Nam"));
        userList.add(new User("Nguyen Van A", 20, "Nam"));
//        hãy chuyển các biểu thức Lambda sau sang dạng Method Reference tương ứng:

        // (user) -> user.getUsername() (Tham chiếu instance method của đối tượng bất kỳ thuộc kiểu cụ thể).
        userList.stream().map(User::getUsername).forEach(System.out::println);

//        (s) -> System.out.println(s) (Tham chiếu instance method của một đối tượng cụ thể).
        userList.stream().map(User::toString).forEach(System.out::println);

//        () -> new User() (Tham chiếu Constructor).
            Supplier<User> newUser = User::new;
    }
}
