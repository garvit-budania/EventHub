package ui;

import dao.TransactionDAO;
import model.Transaction;
import model.User;

import javax.swing.*;
import java.util.ArrayList;

public class TransactionHistoryFrame extends JFrame {

    public TransactionHistoryFrame(User user) {

        setTitle("Transaction History");

        setSize(800, 400);

        setLocationRelativeTo(null);

        TransactionDAO transactionDAO =
                new TransactionDAO();

        ArrayList<Transaction> transactions =
                transactionDAO.getUserTransactions(
                        user.getUserId()
                );

        String[] columnNames = {
                "Transaction ID",
                "Amount",
                "Type"
        };

        String[][] data =
                new String[transactions.size()][3];

        for(int i = 0; i < transactions.size(); i++) {

            Transaction transaction =
                    transactions.get(i);

            data[i][0] =
                    String.valueOf(
                            transaction.getTransactionId()
                    );

            data[i][1] =
                    String.valueOf(
                            transaction.getAmount()
                    );

            data[i][2] =
                    transaction.getTransactionType();
        }

        JTable table =
                new JTable(
                        data,
                        columnNames
                );

        JScrollPane scrollPane =
                new JScrollPane(table);

        add(scrollPane);

        setVisible(true);
    }
}
