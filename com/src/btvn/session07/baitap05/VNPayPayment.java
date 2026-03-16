package btvn.session07.baitap05;

public class VNPayPayment implements PaymentMethod {

    public void pay(double amount) {
        System.out.println("Thanh toán VNPay: " + amount);
    }
}