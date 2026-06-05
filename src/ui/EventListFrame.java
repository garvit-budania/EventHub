package ui;

import dao.EventDAO;
import model.Event;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListFrame extends JFrame {

    public EventListFrame(User user) {

        setTitle("Available Events");

        setSize(900, 500);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        EventDAO eventDAO =
                new EventDAO();

        ArrayList<Event> events =
                eventDAO.getAllEvents();

        String[] columnNames = {
                "ID",
                "Name",
                "Date",
                "Venue",
                "Price",
                "Available Seats"
        };

        String[][] data =
                new String[events.size()][6];

        for(int i = 0; i < events.size(); i++) {

            Event event =
                    events.get(i);

            data[i][0] =
                    String.valueOf(
                            event.getEventId()
                    );

            data[i][1] =
                    event.getEventName();

            data[i][2] =
                    event.getEventDate();

            data[i][3] =
                    event.getVenue();

            data[i][4] =
                    String.valueOf(
                            event.getTicketPrice()
                    );

            data[i][5] =
                    String.valueOf(
                            event.getAvailableSeats()
                    );
        }

        JTable table =
                new JTable(
                        data,
                        columnNames
                );

        JScrollPane scrollPane =
                new JScrollPane(table);

        JButton bookButton =
                new JButton(
                        "Book Selected Event"
                );

        bookButton.addActionListener(e -> {

            int selectedRow =
                    table.getSelectedRow();

            if(selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select an event."
                );

                return;
            }

            Event selectedEvent =
                    events.get(selectedRow);

            new BookingFrame(
                    user,
                    selectedEvent
            );
        });

        add(
                scrollPane,
                BorderLayout.CENTER
        );

        add(
                bookButton,
                BorderLayout.SOUTH
        );

        setVisible(true);
    }
}