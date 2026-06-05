package dao;

import model.Booking;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookingDAO {

    public boolean createBooking(
            int userId,
            int eventId,
            int ticketsBooked,
            double totalAmount
    ) {

        String query =
                "INSERT INTO bookings " +
                "(user_id, event_id, tickets_booked, total_amount) " +
                "VALUES (?, ?, ?, ?)";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setInt(1, userId);
            pstmt.setInt(2, eventId);
            pstmt.setInt(3, ticketsBooked);
            pstmt.setDouble(4, totalAmount);

            int rowsAffected =
                    pstmt.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    public boolean createBooking(
            Connection conn,
            int userId,
            int eventId,
            int ticketsBooked,
            double totalAmount
    ) {

        String query =
                "INSERT INTO bookings " +
                "(user_id, event_id, tickets_booked, total_amount) " +
                "VALUES (?, ?, ?, ?)";

        try {

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setInt(1, userId);
            pstmt.setInt(2, eventId);
            pstmt.setInt(3, ticketsBooked);
            pstmt.setDouble(4, totalAmount);

            return pstmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    public ArrayList<Booking> getUserBookings(
            int userId
    ) {

        ArrayList<Booking> bookings =
                new ArrayList<>();

        String query =
                "SELECT " +
                "b.booking_id, " +
                "b.user_id, " +
                "b.event_id, " +
                "e.event_name, " +
                "b.tickets_booked, " +
                "b.total_amount " +
                "FROM bookings b " +
                "JOIN events e " +
                "ON b.event_id = e.event_id " +
                "WHERE b.user_id = ?";

        try {

            Connection conn =
                    DBConnection.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(query);

            pstmt.setInt(1, userId);

            ResultSet rs =
                    pstmt.executeQuery();

            while (rs.next()) {

                Booking booking =
                        new Booking(
                                rs.getInt("booking_id"),
                                rs.getInt("user_id"),
                                rs.getInt("event_id"),
                                rs.getString("event_name"),
                                rs.getInt("tickets_booked"),
                                rs.getDouble("total_amount")
                        );

                bookings.add(booking);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return bookings;
    }
}
