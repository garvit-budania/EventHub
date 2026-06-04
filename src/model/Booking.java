package model;

public class Booking {

    private int bookingId;
    private int userId;
    private int eventId;
    private int ticketsBooked;
    private double totalAmount;

    public Booking() {}

    public Booking(int bookingId,
                   int userId,
                   int eventId,
                   int ticketsBooked,
                   double totalAmount) {

        this.bookingId = bookingId;
        this.userId = userId;
        this.eventId = eventId;
        this.ticketsBooked = ticketsBooked;
        this.totalAmount = totalAmount;
    }
}
