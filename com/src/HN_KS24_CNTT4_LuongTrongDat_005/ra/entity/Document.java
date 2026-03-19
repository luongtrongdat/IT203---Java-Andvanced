package HN_KS24_CNTT4_LuongTrongDat_005.ra.entity;

import java.util.Scanner;

public class Document {
    private String documentId;
    private String documentName;
    private double fileSize;
    private int dowloads;
    public Document() {
    }
    public Document(String documentId, String documentName, double fileSize, int dowloads) {
        this.documentId = documentId;
        this.documentName = documentName;
        this.fileSize = fileSize;
        this.dowloads = dowloads;
    }
    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public String getDocumentName() {
        return documentName;
    }
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
    public double getFileSize() {
        return fileSize;
    }
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public int getDowloads() {
        return dowloads;
    }
    public void setDowloads(int dowloads) {
        this.dowloads = dowloads;
    }
    public void InputData(Scanner scanner) {
        System.out.print("Nhap ma tai lieu: ");
        while (true) {
            this.documentId = scanner.nextLine();
            if (this.documentId != null && !this.documentId.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Ma tai lieu khong duoc de trong");
            }
        }
        System.out.print("Nhap ten tai lieu: ");
        while (true) {
            this.documentName = scanner.nextLine();
            if (this.documentName != null && !this.documentName.trim().isEmpty()) {
                break;
            } else {
                System.err.println("Ten tai lieu khong duoc de trong");
            }
        }
        System.out.print("Nhap kich thuoc tai lieu (MB): ");
        while (true) {
            try {
                this.fileSize = Double.parseDouble(scanner.nextLine());
                if (this.fileSize > 0) break;
                System.err.println("Kich thuoc file phai lon hon 0");
            } catch (NumberFormatException e) {
                System.err.println("Vui long nhap lai");
            }
        }
        System.out.print("Nhap luot tai xuong: ");
        while (true) {
            try {
                this.dowloads = Integer.parseInt(scanner.nextLine());
                if (this.dowloads >= 0) break;
                System.err.println("Luot tai xuong phai lon hon hoac bang 0");
            } catch (NumberFormatException e) {
                System.err.println("Vui long nhap mot so nguyen");
            }
        }
    }
    public void DisplayData() {
        System.out.printf("| %-12s | %-20s | %-15.2f | %-12d |\n",
        this.documentId,
        this.documentName,
        this.fileSize,
        this.dowloads);
    }
}
