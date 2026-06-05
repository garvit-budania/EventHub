package ui;

import model.User;

import javax.swing.*;
import java.awt.*;

public class CustomerDashboard extends JFrame {

    public CustomerDashboard(User user) {

        setTitle("Customer Dashboard");

        setSize(900, 500);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel welcomeLabel =
                new JLabel(
                        "Welcome, " +
                        user.getUsername() +
                        " | Wallet Balance: ₹" +
                        user.getWalletBalance(),
                        SwingConstants.CENTER
                );

        welcomeLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        add(
                welcomeLabel,
                BorderLayout.NORTH
        );

        JPanel buttonPanel =
                new JPanel();

        JButton viewEventsButton =
                new JButton("View Events");

        JButton bookingHistoryButton =
                new JButton("Booking History");

        JButton transactionHistoryButton =
                new JButton("Transaction History");

        viewEventsButton.addActionListener(e -> {

            new EventListFrame(user);
        });

        bookingHistoryButton.addActionListener(e -> {

            new BookingHistoryFrame(user);
        });

        transactionHistoryButton.addActionListener(e -> {

            new TransactionHistoryFrame(user);
        });

        buttonPanel.add(viewEventsButton);
        buttonPanel.add(bookingHistoryButton);
        buttonPanel.add(transactionHistoryButton);

        add(
                buttonPanel,
                BorderLayout.CENTER
        );

        setVisible(true);
    }
}
