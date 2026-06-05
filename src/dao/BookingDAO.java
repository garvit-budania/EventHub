package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
