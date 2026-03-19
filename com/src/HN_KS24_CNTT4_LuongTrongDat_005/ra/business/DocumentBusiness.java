// + Hiện thị danh sách: thực hiện hiển thị danh sách theo dạng bảng - nếu danh sách rỗng thì in ra lỗi
// + Thêm tài liệu: Nếu trùng DocumeenntId thì thực hiện in ra lỗi trùng lặp,
// + Cập nhật thông tin: Cho người dùng lựa chọn thông tin nào muốn cập nhật
// + Tìm kiếm theo tên: tìm kiếm tương đối ( không phân biệt chữ hoa thường) và trả về đối tượng
// được tìm thấy, nếu không tìm thấy thì in ra lỗi (hiển thị cho tiết thông tin và tổng số liệu tìm thấy)
// + Xóa tài liệu: Nếu kích thước danh sách không đổi sau khi thực hiện (tức là mã tài liệu không tồn tại), thực hiện in ra lỗi
// + Sắp xếp: sắp xếp lượt tải xuống (dowloads) giảm dần, trả về danh sác kết quả vàf hiện thị danh sách đó lên màn hình
// + Lọc: lọc danh sách các tài liệu có lượt tải dowloads >= 1000

package HN_KS24_CNTT4_LuongTrongDat_005.ra.business;

import java.util.*;

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
            System.out.println("Danh sach rong");
        } else {
            showDocumentTable(documents);
        }
    }
    public void showDocumentTable(List<Document> documents) {
        if (documents.isEmpty()) {
            System.out.println("Danh sach rong");
        } else {
            System.out.println("| %-12s | %-12s | %-12s | %-12s | ");
        }
    }
}
