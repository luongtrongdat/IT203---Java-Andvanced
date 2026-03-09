package btvn.session02.baitap05;

public interface UserActions {
    default void logActivity(String activity){
        System.out.println("Vừa thêm hành động: " + activity);
    }
}