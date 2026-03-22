package btvn.session11.baitap02;

import java.sql.*;
import java.util.*;

import btvn.session11.baitap01.DBContext;


public class Main {
    public static void main(String[] args) {
        List<Medicine> medicines = new ArrayList<>();
        try (Connection connection = DBContext.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "select id, medicine_name, stock from medicines";
            ResultSet resultSet = statement.executeQuery(sql);
            // Không thể dùng if vì excuteQuery trả về một bảng
            // để lấy hết các dòng trong bảng thì phải dùng while
            // Lúc này resultSet đang ở trước dòng đầu tiên trong bảng
            // Sau mỗi vòng lòng resultSet sẽ trỏ đến dòng dữ liệu tiếp theo cho đến khi không còn
            while (resultSet.next()) {
                // Lấy dữ liệu từng dòng
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String medicineName = resultSet.getString("medicine_name");
                    int stock = resultSet.getInt("stock");
                    Medicine medicine = new Medicine(id, medicineName, stock);
                    medicines.add(medicine);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // In dữ liệu đã lấy
        medicines.forEach(System.out::println);
    }
}
