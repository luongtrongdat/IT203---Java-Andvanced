package btvn.session07.baitap03;

public interface CODPayable extends PaymentMethod {
    void processCOD(double amount);
}