package btvn.session07.baitap05;

public class HolidayDiscount implements DiscountStrategy {
    public double apply(double amount) {
        return amount * 0.85;
    }
}