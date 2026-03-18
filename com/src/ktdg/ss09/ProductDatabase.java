package ktdg.ss09;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products;

    private ProductDatabase() {
        products = new ArrayList<>();
    }

    public static synchronized ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(String id, Product newProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.set(i, newProduct);
                return;
            }
        }
    }

    public boolean deleteProduct(String id) {
        return products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product findProductById(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}