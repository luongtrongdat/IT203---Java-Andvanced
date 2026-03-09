package btvn.session02;

import java.util.function.Predicate;

public class Baitap02 {
    @FunctionalInterface
    interface PasswordValidator{
        boolean isValid(String password);
    }

    public static void main(String[] args) {
//        PasswordValidator validator = new PasswordValidator() {
//            @Override
//            public boolean isValid = (String password) -> {
//                return password.length() >= 8;
//            };
//        }
        Predicate<String> isValid = password -> password.length() >= 8;

        System.out.println("12345678" + " -> " + isValid.test("12345678"));
        System.out.println("1234 -> " + isValid.test("1234"));
    }
}
