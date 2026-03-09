package btvn.session02.baitap06;

import btvn.session02.baitap04.User;

public class UserUtils {
    public static String convertToUpperCase(User user){
        return user.getUsername().toUpperCase();
    }
}
