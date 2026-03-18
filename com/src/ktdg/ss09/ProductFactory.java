package ktdg.ss09;

public class ProductFactory {
    public static Product createProduct(int type, String id, String name, double price, double additionalAttr) {
        if (type == 1) {
            return new PhysicalProduct(id, name, price, additionalAttr);
        } else if (type == 2) {
            return new DigitalProduct(id, name, price, additionalAttr);
        }
        return null;
    }
}