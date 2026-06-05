package dao;

import model.Transaction;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TransactionDAO {

    public boolean addTransaction(
            int userId,
            double amount,
            String transactionType
    ) {

        String query =
                "INSERT INTO transactions " +
                "(user_id, amount, transaction_type) " +
                "VALUES (?, ?, ?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setInt(1, userId);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, transactionType);

            return pstmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean addTransaction(
            Connection conn,
            int userId,
            double amount,
            String transactionType
    ) {

        String query =
                "INSERT INTO transactions " +
                "(user_id, amount, transaction_type) " +
                "VALUES (?, ?, ?)";

        try {

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setInt(1, userId);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, transactionType);

            return pstmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Transaction> getUserTransactions(
            int userId
    ) {

        ArrayList<Transaction> transactions =
                new ArrayList<>();

        String query =
                "SELECT * " +
                "FROM transactions " +
                "WHERE user_id = ?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setInt(1, userId);

            ResultSet rs =
                    pstmt.executeQuery();

            while (rs.next()) {

                Transaction transaction =
                        new Transaction(
                                rs.getInt("transaction_id"),
                                rs.getInt("user_id"),
                                rs.getDouble("amount"),
                                rs.getString("transaction_type")
                        );

                transactions.add(transaction);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return transactions;
    }
}
