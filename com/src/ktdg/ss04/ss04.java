package ktdg.ss04;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ss04 {
    private static final List<Product> productList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        productList.add(new Product(1, "Laptop Dell XPS", 25000000, 10, "Laptop"));
        productList.add(new Product(2, "iPhone 15 Pro", 30000000, 5, "Smartphone"));
        productList.add(new Product(3, "Bàn phím cơ", 1500000, 0, "Phụ kiện"));
        productList.add(new Product(4, "Màn hình LG 27'", 7000000, 8, "Màn hình"));

        int choice = 0;
        while (choice != 5) {
            printMenu();
            try {
                System.out.print("Lựa chọn của bạn: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addNewProduct();
                        break;
                    case 2:
                        displayProducts();
                        break;
                    case 3:
                        updateProductQuantity();
                        break;
                    case 4:
                        deleteOutOfStockProducts();
                        break;
                    case 5:
                        System.out.println("Đã thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại từ 1 đến 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên cho lựa chọn.");
            } catch (InvalidProductException e) {
                System.out.println("Lỗi xử lý sản phẩm: " + e.getMessage());
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("========= PRODUCT MANAGEMENT SYSTEM =========");
        System.out.println("1. Thêm sản phẩm mới");
        System.out.println("2. Hiển thị danh sách sản phẩm");
        System.out.println("3. Cập nhật số lượng theo ID");
        System.out.println("4. Xóa sản phẩm đã hết hàng");
        System.out.println("5. Thoát chương trình");
        System.out.println("=============================================");
    }

    private static void addNewProduct() throws InvalidProductException {
        System.out.println("--- 1. Thêm sản phẩm mới ---");
        try {
            System.out.print("Nhập ID sản phẩm: ");
            int id = Integer.parseInt(scanner.nextLine());

            boolean idExists = productList.stream().anyMatch(p -> p.getId() == id);
            if (idExists) {
                throw new InvalidProductException("ID '" + id + "' đã tồn tại. Vui lòng nhập ID khác.");
            }

            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập số lượng tồn kho: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập danh mục sản phẩm: ");
            String category = scanner.nextLine();

            productList.add(new Product(id, name, price, quantity, category));
            System.out.println("=> Thêm sản phẩm thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID, giá, và số lượng phải là số.");
        }
    }

    private static void displayProducts() {
        System.out.println("--- 2. Hiển thị danh sách sản phẩm ---");
        if (productList.isEmpty()) {
            System.out.println("Kho sản phẩm trống.");
            return;
        }
        System.out.println("+------+----------------------+--------------+----------+-----------------+");
        System.out.println("| ID   | Tên sản phẩm         | Giá          | Số lượng | Danh mục        |");
        System.out.println("+------+----------------------+--------------+----------+-----------------+");
        productList.forEach(System.out::println);
        System.out.println("+------+----------------------+--------------+----------+-----------------+");
    }

    private static void updateProductQuantity() throws InvalidProductException {
        System.out.println("--- 3. Cập nhật số lượng theo ID ---");
        try {
            System.out.print("Nhập ID sản phẩm cần cập nhật: ");
            int id = Integer.parseInt(scanner.nextLine());

            Optional<Product> productOpt = productList.stream()
                    .filter(p -> p.getId() == id)
                    .findFirst();

            Product productToUpdate = productOpt.orElseThrow(() -> new InvalidProductException("Sản phẩm với ID '" + id + "' không tồn tại."));

            System.out.print("Nhập số lượng mới: ");
            int newQuantity = Integer.parseInt(scanner.nextLine());

            productToUpdate.setQuantity(newQuantity);
            System.out.println("=> Cập nhật số lượng cho sản phẩm ID " + id + " thành công!");

        } catch (NumberFormatException e) {
            System.out.println("Lỗi: ID và số lượng phải là số nguyên.");
        }
    }

    private static void deleteOutOfStockProducts() {
        System.out.println("--- 4. Xóa sản phẩm đã hết hàng ---");
        long initialSize = productList.size();

        productList.removeIf(product -> product.getQuantity() == 0);

        long finalSize = productList.size();
        long removedCount = initialSize - finalSize;

        if (removedCount > 0) {
            System.out.println("=> Đã xóa thành công " + removedCount + " sản phẩm hết hàng.");
        } else {
            System.out.println("Không có sản phẩm nào hết hàng để xóa.");
        }
    }
}

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(int id, String name, double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
        return String.format("| %-4d | %-20s | %,12.0f | %-8d | %-15s |",
                id, name, price, quantity, category);
    }
}

class InvalidProductException extends Exception {
    public InvalidProductException(String message) {
        super(message);
    }
}
