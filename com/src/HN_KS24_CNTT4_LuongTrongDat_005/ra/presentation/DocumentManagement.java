// Thư viện trung tâm của một trường đại học cần só hóa kho tài liệu nhưng phần mềm cũ không đáp ứng được
// tốc độ xử lý. Họ cần một hệ thống mới để quản lý thông tin các tài liệu số, tra cứu tài liệu nhanh chóng,
// lọc ra các tài liệu được sinh viên tải về nhiều nhất để ưu tiên băng thông, và đảm bảo k có mã tài liệu nào
// bị nhập trùng. Hãy viết chương trình java để thực hiện các yêu cầu kiến trúc sau:\
// 1. Xây dựng các lớp sau(Package: ra.entity):
// - Xây dựng lớp Document gồm:
// + Các thuộc tính:
//    documentId (String): mã tài liệu không được trùng lặp
//    documentName (String): tên tài liệu
//    fileSize (double): Dung lượng file (MB) phải lớn hơn 0
//    download (int): Lượt tải xuống phải lớn hơn hoặc bằng 0
// + Gồm 2 constructor: không tham số và đầy đủ các tham số
// + Gồm phương thức getter/setter
// + Phương thức InputData() hiện thị thông tin tài liệu ra màn hình với định dạng bảng rõ ràng
// 2. Xây dựng lớp nghiệp vụ sau (Package: ra.business):
// - Tạo một lớp DocumentBusiness quản lý một danh sách List<Document> đối tượng DocumentBusiness
// chỉ được tồn tại duy nhất 1 lần (áp dụng Design Pattern). Xây dựng các phương thức xử lý logic dưới đây.
// Bắt buộc sử dụng Java8 (Stream API, Lambda, Optional) cho các thao tác:

package HN_KS24_CNTT4_LuongTrongDat_005.ra.presentation;

public class DocumentManagement {
    
}
