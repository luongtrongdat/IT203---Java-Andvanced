package btvn.session02.baitap06;

import java.util.function.Supplier;

import btvn.session02.baitap04.User;

public class Main {
    public static void main(String[] args) {
        UserProcessor up  = (u) -> UserUtils.convertToUpperCase(u); // Sử dụng Lamda

        UserProcessor userProcessor = UserUtils::convertToUpperCase; // Áp dụng Method Expression

        User newUser = new User("Nguyen Van A", 20, "Nam");
        Supplier<String> supplier = newUser::toString;
        System.out.println(supplier.get());

        String result = userProcessor.process(newUser);
        System.out.println(result);
    }
}
