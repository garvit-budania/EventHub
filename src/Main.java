import dao.UserDAO;
import model.User;

public class Main {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        User loggedInUser =
                dao.loginUser(
                        "GB",
                        "123"
                );

        if(loggedInUser != null) {

            System.out.println(
                    "Login Successful!"
            );

            System.out.println(
                    loggedInUser
            );

        } else {

            System.out.println(
                    "Invalid Credentials!"
            );
        }
    }
}
