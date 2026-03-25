package ktdg.ss14.service;

import ktdg.ss14.entity.Account;
import ktdg.ss14.util.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class AccountService {

    public void transferMoney(String fromAccountId, String toAccountId, BigDecimal amount) {
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement checkStmt = null;
        CallableStatement updateStmt = null;

        try {
            conn.setAutoCommit(false);

            String checkSql = "SELECT Balance FROM Accounts WHERE AccountId = ?";
            checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, fromAccountId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                BigDecimal currentBalance = rs.getBigDecimal("Balance");
                if (currentBalance.compareTo(amount) < 0) {
                    throw new SQLException("Tai khoan nguoi gui khong du so du de thuc hien giao dich!");
                }
            } else {
                throw new SQLException("Tai khoan nguoi gui khong ton tai!");
            }
            rs.close();
            String checkReceiverSql = "SELECT AccountId FROM Accounts WHERE AccountId = ?";
            PreparedStatement checkReceiver = conn.prepareStatement(checkReceiverSql);
            checkReceiver.setString(1, toAccountId);
            ResultSet rs2 = checkReceiver.executeQuery();

            if (!rs2.next()) {
                throw new SQLException("Tai khoan nguoi nhan khong ton tai!");
            }

            rs2.close();
            checkReceiver.close();

            String procedureSql = "{call sp_UpdateBalance(?, ?)}";
            updateStmt = conn.prepareCall(procedureSql);

            updateStmt.setString(1, fromAccountId);
            updateStmt.setBigDecimal(2, amount.negate());
            updateStmt.executeUpdate();

            updateStmt.setString(1, toAccountId);
            updateStmt.setBigDecimal(2, amount);
            updateStmt.executeUpdate();

            conn.commit();
            System.out.println("=== Giao dich thanh cong! ===");
            System.out.println("Da chuyen " + amount + " tu " + fromAccountId + " sang " + toAccountId);

        } catch (SQLException e) {
            System.err.println("=== Loi giao dich: " + e.getMessage() + " ===");
            System.err.println("Dang khoi phuc lai du lieu (Rollback)...");
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);
                if (checkStmt != null) checkStmt.close();
                if (updateStmt != null) updateStmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayAllAccounts() {
        String sql = "SELECT * FROM Accounts";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n=== DANH SACH TAI KHOAN ===");
            System.out.printf("| %-10s | %-20s | %-15s |\n", "AccountID", "FullName", "Balance");
            System.out.println("-------------------------------------------------------");
            
            while (rs.next()) {
                Account acc = new Account();
                acc.setAccountId(rs.getString("AccountId"));
                acc.setFullName(rs.getString("FullName"));
                acc.setBalance(rs.getBigDecimal("Balance"));
                System.out.println(acc.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}