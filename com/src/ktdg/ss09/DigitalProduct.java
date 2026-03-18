package ktdg.ss09;

public class DigitalProduct extends Product {
    private double size;

    public DigitalProduct(String id, String name, double price, double size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Digital Product  - ID: %s | Name: %s | Price: %.2f | Size: %.2f MB%n",
                getId(), getName(), getPrice(), size);
    }
}