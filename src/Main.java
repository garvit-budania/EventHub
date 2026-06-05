import dao.BookingDAO;
import dao.EventDAO;
import dao.UserDAO;
import model.Event;
import model.User;

public class Main {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        EventDAO eventDAO = new EventDAO();
        BookingDAO bookingDAO = new BookingDAO();

        User user =
                userDAO.loginUser(
                        "GB",
                        "123"
                );

        if(user == null) {

            System.out.println(
                    "User not found!"
            );

            return;
        }

        Event event =
                eventDAO.getAllEvents().get(0);

        int tickets = 2;

        double totalCost =
                tickets *
                event.getTicketPrice();

        if(user.getWalletBalance() < totalCost) {

            System.out.println(
                    "Insufficient Wallet Balance!"
            );

            return;
        }

        if(event.getAvailableSeats() < tickets) {

            System.out.println(
                    "Not Enough Seats Available!"
            );

            return;
        }

        double newBalance =
                user.getWalletBalance()
                - totalCost;

        int newSeats =
                event.getAvailableSeats()
                - tickets;

        boolean walletUpdated =
                userDAO.updateWallet(
                        user.getUserId(),
                        newBalance
                );

        boolean seatsUpdated =
                eventDAO.updateSeats(
                        event.getEventId(),
                        newSeats
                );

        boolean bookingCreated =
                bookingDAO.createBooking(
                        user.getUserId(),
                        event.getEventId(),
                        tickets,
                        totalCost
                );

        if(walletUpdated &&
           seatsUpdated &&
           bookingCreated) {

            System.out.println(
                    "Booking Successful!"
            );

        } else {

            System.out.println(
                    "Booking Failed!"
            );
        }
    }
}