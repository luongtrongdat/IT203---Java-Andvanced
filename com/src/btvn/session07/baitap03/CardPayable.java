package btvn.session07.baitap03;

public interface CardPayable extends PaymentMethod {
    void processCreditCard(double amount);
}
