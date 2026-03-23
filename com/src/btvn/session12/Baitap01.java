package btvn.session12;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import btvn.session12.connections.DatabaseConnection;

public class Baitap01 {
    public static void main(String[] args) {
        // Việc biên dịch trước cho phép JDBC thực hiện các kiểm tra và xác định kiểu dữ liệu của tham số trước khi gửi đi,
        // và cung cấp một cơ chế để chỉnh sửa các tham số đầu vào sau này mà không cần phải biên dịch lại toàn bộ câu truy vấn SQL.
        // Điều này giúp giảm thiểu hệ thống các câu lệnh SQL độc hại và tối ưu hóa hiệu suất trong việc xử lý các câu truy vấn có tham số đầu vào.
        String sql = "select * from doctors where doctor_id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getString("full_name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}