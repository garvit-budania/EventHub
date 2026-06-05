package ui;

import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    public AdminDashboard() {

        setTitle("Admin Dashboard");

        setSize(800, 400);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel titleLabel =
                new JLabel(
                        "Admin Dashboard",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        add(
                titleLabel,
                BorderLayout.NORTH
        );

        JPanel buttonPanel =
                new JPanel();

        JButton createEventButton =
                new JButton(
                        "Create Event"
                );

        JButton viewEventsButton =
                new JButton(
                        "View Events"
                );

        createEventButton.addActionListener(e -> {

            new CreateEventFrame();
        });

        viewEventsButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Event Viewer Coming Next"
            );
        });

        buttonPanel.add(createEventButton);
        buttonPanel.add(viewEventsButton);

        add(
                buttonPanel,
                BorderLayout.CENTER
        );

        setVisible(true);
    }
}
