import dao.EventDAO;
import dao.UserDAO;
import model.Event;
import model.User;
import service.BookingService;

public class Main {

    public static void main(String[] args) {

        UserDAO userDAO =
                new UserDAO();

        EventDAO eventDAO =
                new EventDAO();

        BookingService bookingService =
                new BookingService();

        User userA =
                userDAO.loginUser(
                        "UserA",
                        "123"
                );

        User userB =
                userDAO.loginUser(
                        "UserB",
                        "123"
                );

        Event event =
                eventDAO.getAllEvents().get(1);

        Thread t1 =
                new Thread(() -> {

                    boolean success =
                            bookingService.bookTicket(
                                    userA,
                                    event,
                                    1
                            );

                    System.out.println(
                            "UserA Booking: "
                                    + success
                    );
                });

        Thread t2 =
                new Thread(() -> {

                    boolean success =
                            bookingService.bookTicket(
                                    userB,
                                    event,
                                    1
                            );

                    System.out.println(
                            "UserB Booking: "
                                    + success
                    );
                });

        t1.start();
        t2.start();
    }
}