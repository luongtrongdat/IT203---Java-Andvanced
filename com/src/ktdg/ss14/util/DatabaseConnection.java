package ktdg.ss14.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/ktdg_ss14";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private static Connection connection;

    public static Connection getConnection() {

        try {
            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(URL, USER, PASSWORD);

                System.out.println("Kết nối database thành công!");
            }

        } catch (Exception e) {
            System.out.println("Lỗi kết nối database!");
            e.printStackTrace();
        }

        return connection;
    }
}