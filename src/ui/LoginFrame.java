package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {

        setTitle("EventHub Login");

        setSize(450, 300);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel usernameLabel =
                new JLabel("Username:");

        usernameField =
                new JTextField();

        JLabel passwordLabel =
                new JLabel("Password:");

        passwordField =
                new JPasswordField();

        JButton loginButton =
                new JButton("Login");

        JButton registerButton =
                new JButton("Register");

        loginButton.addActionListener(e -> {

            String username =
                    usernameField.getText();

            String password =
                    new String(
                            passwordField.getPassword()
                    );

            UserDAO userDAO =
                    new UserDAO();

            User user =
                    userDAO.loginUser(
                            username,
                            password
                    );

            if (user != null) {

                dispose();

                if(user.getRole().equalsIgnoreCase("ADMIN")) {

                    new AdminDashboard();

                } else {

                    new CustomerDashboard(user);
                }

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Credentials!"
                );
            }
        });

        registerButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Register Feature Coming Soon!"
            );
        });

        add(new JLabel());

        add(new JLabel("EventHub Login"));

        add(usernameLabel);
        add(usernameField);

        add(passwordLabel);
        add(passwordField);

        add(loginButton);
        add(registerButton);

        setVisible(true);
    }
}