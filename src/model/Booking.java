package model;

public class Booking {

    private int bookingId;
    private int userId;
    private int eventId;
    private String eventName;
    private int ticketsBooked;
    private double totalAmount;

    public Booking() {
    }

    public Booking(int bookingId,
                   int userId,
                   int eventId,
                   String eventName,
                   int ticketsBooked,
                   double totalAmount) {

        this.bookingId = bookingId;
        this.userId = userId;
        this.eventId = eventId;
        this.eventName = eventName;
        this.ticketsBooked = ticketsBooked;
        this.totalAmount = totalAmount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public int getTicketsBooked() {
        return ticketsBooked;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {

        return "Booking{" +
                "bookingId=" + bookingId +
                ", eventName='" + eventName + '\'' +
                ", ticketsBooked=" + ticketsBooked +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
