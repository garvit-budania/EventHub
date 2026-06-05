package ui;

import model.Event;
import model.User;
import service.BookingService;

import javax.swing.*;
import java.awt.*;

public class BookingFrame extends JFrame {

    public BookingFrame(
            User user,
            Event event
    ) {

        setTitle("Book Ticket");

        setSize(400, 350);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 1));

        JLabel eventLabel =
                new JLabel(
                        "Event: " +
                        event.getEventName()
                );

        JLabel venueLabel =
                new JLabel(
                        "Venue: " +
                        event.getVenue()
                );

        JLabel priceLabel =
                new JLabel(
                        "Ticket Price: ₹" +
                        event.getTicketPrice()
                );

        JLabel seatsLabel =
                new JLabel(
                        "Available Seats: " +
                        event.getAvailableSeats()
                );

        JLabel quantityLabel =
                new JLabel(
                        "Number of Tickets:"
                );

        JTextField quantityField =
                new JTextField();

        JButton bookButton =
                new JButton(
                        "Book Ticket"
                );

        bookButton.addActionListener(e -> {

            try {

                int tickets =
                        Integer.parseInt(
                                quantityField.getText()
                        );

                BookingService bookingService =
                        new BookingService();

                boolean success =
                        bookingService.bookTicket(
                                user,
                                event,
                                tickets
                        );

                if(success) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Booking Successful!"
                    );

                    dispose();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Booking Failed!"
                    );
                }

            } catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Ticket Quantity"
                );
            }
        });

        add(eventLabel);
        add(venueLabel);
        add(priceLabel);
        add(seatsLabel);
        add(quantityLabel);
        add(quantityField);
        add(bookButton);

        setVisible(true);
    }
}
