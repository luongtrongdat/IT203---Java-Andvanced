package ktdg.ss09;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ProductDatabase database = ProductDatabase.getInstance();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n---------------------- QUAN LY SAN PHAM ----------------------");
            System.out.println("1. Them moi san pham");
            System.out.println("2. Xem danh sach san pham");
            System.out.println("3. Cap nhat thong tin san pham");
            System.out.println("4. Xoa san pham");
            System.out.println("5. Thoat");
            System.out.println("--------------------------------------------------------------");
            System.out.print("Lua chon cua ban: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so hop le!");
                continue;
            }

            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
            }
        }
    }

    private static void addNewProduct() {
        System.out.println("Chon loai san pham: 1. Physical Product | 2. Digital Product");
        int type = Integer.parseInt(scanner.nextLine());
        
        if (type != 1 && type != 2) {
            System.out.println("Loai san pham khong hop le.");
            return;
        }

        System.out.print("Nhap ID: ");
        String id = scanner.nextLine();
        System.out.print("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.print("Nhap gia: ");
        double price = Double.parseDouble(scanner.nextLine());

        double attr = 0;
        if (type == 1) {
            System.out.print("Nhap trong luong (kg): ");
            attr = Double.parseDouble(scanner.nextLine());
        } else {
            System.out.print("Nhap dung luong (MB): ");
            attr = Double.parseDouble(scanner.nextLine());
        }

        Product product = ProductFactory.createProduct(type, id, name, price, attr);
        if (product != null) {
            database.addProduct(product);
            System.out.println("Them san pham thanh cong!");
        }
    }

    private static void viewAllProducts() {
        List<Product> list = database.getAllProducts();
        if (list.isEmpty()) {
            System.out.println("Danh sach trong.");
        } else {
            for (Product p : list) {
                p.displayInfo();
            }
        }
    }

    private static void updateProduct() {
        System.out.print("Nhap ID san pham can cap nhat: ");
        String id = scanner.nextLine();
        Product existing = database.findProductById(id);

        if (existing == null) {
            System.out.println("Khong tim thay san pham voi ID: " + id);
            return;
        }

        System.out.println("Nhap thong tin moi:");
        System.out.print("Ten moi: ");
        String name = scanner.nextLine();
        System.out.print("Gia moi: ");
        double price = Double.parseDouble(scanner.nextLine());
        
        int type = (existing instanceof PhysicalProduct) ? 1 : 2;
        double attr = 0;
        System.out.print(type == 1 ? "Trong luong moi (kg): " : "Dung luong moi (MB): ");
        attr = Double.parseDouble(scanner.nextLine());

        Product newProduct = ProductFactory.createProduct(type, id, name, price, attr);
        database.updateProduct(id, newProduct);
        System.out.println("Cap nhat thanh cong!");
    }

    private static void deleteProduct() {
        System.out.print("Nhap ID san pham can xoa: ");
        String id = scanner.nextLine();
        if (database.deleteProduct(id)) {
            System.out.println("Xoa san pham thanh cong!");
        } else {
            System.out.println("Khong tim thay san pham de xoa.");
        }
    }
}
