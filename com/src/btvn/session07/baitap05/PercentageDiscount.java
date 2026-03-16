package btvn.session07.baitap05;

public class PercentageDiscount implements DiscountStrategy {

    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    public double apply(double amount) {
        return amount - amount * percent / 100;
    }
}