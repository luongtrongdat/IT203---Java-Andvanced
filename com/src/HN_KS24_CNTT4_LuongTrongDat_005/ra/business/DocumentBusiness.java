package HN_KS24_CNTT4_LuongTrongDat_005.ra.business;

import java.util.*;
import java.util.stream.Collectors;

import HN_KS24_CNTT4_LuongTrongDat_005.ra.entity.Document;

public class DocumentBusiness {
    public static DocumentBusiness instance;
    public static DocumentBusiness getInstance() {
        if (instance == null) {
            instance = new DocumentBusiness();
        }
        return instance;
    }
    private List<Document> documents = new ArrayList<>();

    public void listDocument() {
        if (documents.isEmpty()) {
            System.out.println("Danh sach tai lieu rong");
        } else {
            System.out.println("---------- DANH SACH TAI LIEU ----------");
            showDocumentTable(documents);
        }
    }
    public void showDocumentTable(List<Document> docList) {
        if (docList.isEmpty()) {
            System.out.println("Danh sach tai lieu rong");
        } else {
            System.out.printf("| %-12s | %-20s | %-15s | %-12s |\n", "MA TAI LIEU", "TEN TAI LIEU", "KICH THUOC(MB)", "LUOT TAI");
            System.out.println("----------------------------------------------------------------------");
            docList.forEach(Document::DisplayData);
        }
    }

    public boolean addDocument(Document doc) {
        boolean isExist = documents.stream().anyMatch(d -> d.getDocumentId().equals(doc.getDocumentId()));
        if (isExist) {
            return false;
        }
        documents.add(doc);
        return true;
    }

    public Optional<Document> findDocumentById(String id) {
        return documents.stream().filter(d -> d.getDocumentId().equals(id)).findFirst();
    }

    public boolean deleteDocument(String deleteId) {
        return documents.removeIf(d -> d.getDocumentId().equals(deleteId));
    }

    public List<Document> searchByName(String searchTerm) {
        return documents.stream()
                .filter(d -> d.getDocumentName().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Document> sort() {
        return documents.stream()
                .sorted(Comparator.comparingInt(Document::getDowloads).reversed())
                .collect(Collectors.toList());
    }
}
