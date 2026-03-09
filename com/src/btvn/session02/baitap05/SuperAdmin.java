package btvn.session02.baitap05;

public class SuperAdmin implements UserActions, AdminActions {
    // Class đang kế thừa nhiều phương thức mặc định (default methods) không liên quan từ các interface khác nhau
    // nên Java không biết phải dùng cái nào.

    // Tiến hành ghi đè để xử lý
    @Override
    public void logActivity(String activity) {
        UserActions.super.logActivity(activity);
    }

    public static void main(String[] args) {
        SuperAdmin newSA = new SuperAdmin();
        newSA.logActivity("Hoc bai");
    }
}
