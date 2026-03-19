package HN_KS24_CNTT4_LuongTrongDat_005.ra.presentation;

import HN_KS24_CNTT4_LuongTrongDat_005.ra.business.DocumentBusiness;
import HN_KS24_CNTT4_LuongTrongDat_005.ra.entity.Document;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DocumentManagement {
    private static final DocumentBusiness documentBusiness = DocumentBusiness.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        documentBusiness.addDocument(new Document("D001", "Java5", 15, 100));
        documentBusiness.addDocument(new Document("D002", "Java8", 8, 950));
        documentBusiness.addDocument(new Document("D003", "Database", 25, 500));
        documentBusiness.addDocument(new Document("D004", "Web ", 12, 800));


        do {
            System.out.println("\n========== DOCUMENT MANAGEMENT ==========");
            System.out.println("1. Hien thi danh sach tai lieu");
            System.out.println("2. Them moi tai lieu");
            System.out.println("3. Cap nhat thong tin tai lieu");
            System.out.println("4. Xoa tai lieu");
            System.out.println("5. Tim kiem tai lieu theo ten");
            System.out.println("6. Sap xep tai lieu theo luot tai giam dan");
            System.out.println("7. Loc tai lieu co luot tai >= 1000");
            System.out.println("8. Thoat");
            System.out.print("Lua chon cua ban: ");

            String inputChoice = scanner.nextLine();
            if (inputChoice.matches("\\d+")) {
                int choice = Integer.parseInt(inputChoice);
                switch (choice) {
                    case 1:
                        documentBusiness.listDocument();
                        break;
                    case 2:
                        System.out.println("Nhap thong tin cho tai lieu moi:");
                        Document newDoc = new Document();
                        newDoc.InputData(scanner);
                        if (documentBusiness.addDocument(newDoc)) {
                            System.out.println("Them moi tai lieu thanh cong.");
                        } else {
                            System.err.println("Loi: Ma tai lieu da ton tai.");
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.print("Nhap ma tai lieu can xoa: ");
                        String deleteId = scanner.nextLine();
                        if (documentBusiness.deleteDocument(deleteId)) {
                            System.out.println("Xoa tai lieu thanh cong.");
                        } else {
                            System.err.println("Loi: Khong tim thay tai lieu voi ma da nhap, xoa that bai.");
                        }
                        break;
                    case 5:
                        System.out.print("Nhap ten tai lieu can tim: ");
                        String searchTerm = scanner.nextLine();
                        List<Document> foundDocuments = documentBusiness.searchByName(searchTerm);
                        System.out.println("Tim thay " + foundDocuments.size() + " tai lieu:");
                        documentBusiness.showDocumentTable(foundDocuments);
                        break;
                    case 6:
                        System.out.println("---------- DANH SACH SAU KHI SAP XEP ----------");
                        documentBusiness.showDocumentTable(documentBusiness.sort());
                        break;
                    case 7:
                        break;
                    case 8:
                        System.out.println("Thoat chuong trinh");
                        break;
                    default:
                        System.err.println("Lua chon khong hop le");
                }
            } else {
                System.err.println("Vui long nhap mot so nguyen");
            }
        } while (true);
    }
}