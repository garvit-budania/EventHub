package model;

public class User {

    private int userId;
    private String username;
    private String password;
    private String role;
    private double walletBalance;

    public User() {
    }

    public User(int userId, String username,
                String password,
                String role,
                double walletBalance) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.walletBalance = walletBalance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", walletBalance=" + walletBalance +
                '}';
    }
}
