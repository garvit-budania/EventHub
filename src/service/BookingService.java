package service;

import dao.BookingDAO;
import dao.EventDAO;
import dao.TransactionDAO;
import dao.UserDAO;
import model.Event;
import model.User;
import util.DBConnection;

import java.sql.Connection;

public class BookingService {

    private UserDAO userDAO;
    private EventDAO eventDAO;
    private BookingDAO bookingDAO;
    private TransactionDAO transactionDAO;

    public BookingService() {

        userDAO = new UserDAO();
        eventDAO = new EventDAO();
        bookingDAO = new BookingDAO();
        transactionDAO = new TransactionDAO();
    }

    public synchronized boolean bookTicket(
            User user,
            Event event,
            int tickets
    ) {

        Connection conn = null;

        try {

            conn = DBConnection.getConnection();

            conn.setAutoCommit(false);

            Event latestEvent =
                    eventDAO.getEventById(
                            conn,
                            event.getEventId()
                    );

            if (latestEvent == null) {

                conn.rollback();
                return false;
            }

            double totalCost =
                    tickets *
                    latestEvent.getTicketPrice();

            if (user.getWalletBalance() < totalCost) {

                System.out.println(
                        "Insufficient Wallet Balance!"
                );

                conn.rollback();
                return false;
            }

            if (latestEvent.getAvailableSeats() < tickets) {

                System.out.println(
                        "Not Enough Seats Available!"
                );

                conn.rollback();
                return false;
            }

            double newBalance =
                    user.getWalletBalance()
                    - totalCost;

            int newSeats =
                    latestEvent.getAvailableSeats()
                    - tickets;

            boolean walletUpdated =
                    userDAO.updateWallet(
                            conn,
                            user.getUserId(),
                            newBalance
                    );

            boolean seatsUpdated =
                    eventDAO.updateSeats(
                            conn,
                            latestEvent.getEventId(),
                            newSeats
                    );

            boolean bookingCreated =
                    bookingDAO.createBooking(
                            conn,
                            user.getUserId(),
                            latestEvent.getEventId(),
                            tickets,
                            totalCost
                    );

            boolean transactionCreated =
                    transactionDAO.addTransaction(
                            conn,
                            user.getUserId(),
                            totalCost,
                            "TICKET_PURCHASE"
                    );

            if (walletUpdated &&
                seatsUpdated &&
                bookingCreated &&
                transactionCreated) {

                conn.commit();

                System.out.println(
                        "Transaction Committed!"
                );

                return true;
            }

            conn.rollback();

            System.out.println(
                    "Transaction Rolled Back!"
            );

            return false;

        } catch (Exception e) {

            try {

                if (conn != null) {
                    conn.rollback();
                }

            } catch (Exception ex) {

                ex.printStackTrace();
            }

            e.printStackTrace();

            return false;

        } finally {

            try {

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}
