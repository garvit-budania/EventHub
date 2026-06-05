package dao;

import model.Event;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EventDAO {

    public boolean createEvent(Event event) {

        String query =
                "INSERT INTO events " +
                "(event_name, event_date, venue, ticket_price, total_seats, available_seats) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setString(1, event.getEventName());
            pstmt.setString(2, event.getEventDate());
            pstmt.setString(3, event.getVenue());
            pstmt.setDouble(4, event.getTicketPrice());
            pstmt.setInt(5, event.getTotalSeats());
            pstmt.setInt(6, event.getAvailableSeats());

            int rowsAffected =
                    pstmt.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Event> getAllEvents() {

        ArrayList<Event> events =
                new ArrayList<>();

        String query =
                "SELECT * FROM events";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            ResultSet rs =
                    pstmt.executeQuery();

            while (rs.next()) {

                Event event =
                        new Event(
                                rs.getInt("event_id"),
                                rs.getString("event_name"),
                                rs.getString("event_date"),
                                rs.getString("venue"),
                                rs.getDouble("ticket_price"),
                                rs.getInt("total_seats"),
                                rs.getInt("available_seats")
                        );

                events.add(event);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return events;
    }

    public boolean updateSeats(
            int eventId,
            int newAvailableSeats
    ) {

        String query =
                "UPDATE events " +
                "SET available_seats = ? " +
                "WHERE event_id = ?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setInt(1, newAvailableSeats);
            pstmt.setInt(2, eventId);

            int rowsAffected =
                    pstmt.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}
