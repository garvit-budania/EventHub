package ui;

import dao.EventDAO;
import model.Event;

import javax.swing.*;
import java.awt.*;

public class CreateEventFrame extends JFrame {

    public CreateEventFrame() {

        setTitle("Create Event");

        setSize(500, 400);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 2));

        JTextField nameField =
                new JTextField();

        JTextField dateField =
                new JTextField();

        JTextField venueField =
                new JTextField();

        JTextField priceField =
                new JTextField();

        JTextField seatsField =
                new JTextField();

        JButton createButton =
                new JButton(
                        "Create Event"
                );

        add(new JLabel("Event Name"));
        add(nameField);

        add(new JLabel("Event Date"));
        add(dateField);

        add(new JLabel("Venue"));
        add(venueField);

        add(new JLabel("Ticket Price"));
        add(priceField);

        add(new JLabel("Total Seats"));
        add(seatsField);

        add(new JLabel());
        add(createButton);

        createButton.addActionListener(e -> {

            try {

                String name =
                        nameField.getText();

                String date =
                        dateField.getText();

                String venue =
                        venueField.getText();

                double price =
                        Double.parseDouble(
                                priceField.getText()
                        );

                int seats =
                        Integer.parseInt(
                                seatsField.getText()
                        );

                Event event =
                        new Event(
                                0,
                                name,
                                date,
                                venue,
                                price,
                                seats,
                                seats
                        );

                EventDAO eventDAO =
                        new EventDAO();

                boolean success =
                        eventDAO.createEvent(
                                event
                        );

                if(success) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Event Created Successfully!"
                    );

                    dispose();

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Failed To Create Event!"
                    );
                }

            } catch(Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Input!"
                );
            }
        });

        setVisible(true);
    }
}
