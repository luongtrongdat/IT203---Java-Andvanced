package HN_KS24_CNTT4_LuongTrongDat_005.ra.entity;

import java.util.Scanner;

public class Document {
    private String documentId;
    private String documentName;
    private double fileSize;
    private int dowloads;

    public Document(String documentId, String documentName, double fileSize, int dowloads) {
        this.documentId = documentId;
        this.documentName = documentName;
        this.fileSize = fileSize;
        this.dowloads = dowloads;
    }
    public String getDocumentId() {
        return documentId;
    }
    public String getDocumentName() {
        return documentName;
    }
    public double getFileSize() {
        return fileSize;
    }
    public int getDowloads() {
        return dowloads;
    }
    public void InputData(Scanner scanner) {
        System.out.print("Nhap ma tai lieu: ");
        this.documentId = scanner.nextLine();
        System.out.print("Nhap ten tai lieu: ");
        this.documentName = scanner.nextLine();
        System.out.print("Nhap kich thuoc tai lieu (MB): ");
        this.fileSize = scanner.nextDouble();
        System.out.print("Nhap luot tai xuong: ");
        this.dowloads = scanner.nextInt();
    }
    public void DisplayData() {
        System.out.printf("| %-12s | %-12s | %-12s | %-12s |",
        this.documentId,
        this.documentName,
        this.fileSize,
        this.dowloads);
    }
}
