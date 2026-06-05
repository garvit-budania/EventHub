package ui;

import dao.BookingDAO;
import model.Booking;
import model.User;

import javax.swing.*;
import java.util.ArrayList;

public class BookingHistoryFrame extends JFrame {

    public BookingHistoryFrame(User user) {

        setTitle("Booking History");

        setSize(800, 400);

        setLocationRelativeTo(null);

        BookingDAO bookingDAO =
                new BookingDAO();

        ArrayList<Booking> bookings =
                bookingDAO.getUserBookings(
                        user.getUserId()
                );

        String[] columnNames = {
                "Booking ID",
                "Event Name",
                "Tickets",
                "Total Amount"
        };

        String[][] data =
                new String[bookings.size()][4];

        for(int i = 0; i < bookings.size(); i++) {

            Booking booking =
                    bookings.get(i);

            data[i][0] =
                    String.valueOf(
                            booking.getBookingId()
                    );

            data[i][1] =
                    booking.getEventName();

            data[i][2] =
                    String.valueOf(
                            booking.getTicketsBooked()
                    );

            data[i][3] =
                    String.valueOf(
                            booking.getTotalAmount()
                    );
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
