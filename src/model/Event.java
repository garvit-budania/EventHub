package model;

public class Event {

    private int eventId;
    private String eventName;
    private String eventDate;
    private String venue;
    private double ticketPrice;
    private int totalSeats;
    private int availableSeats;

    public Event() {}

    public Event(int eventId, String eventName,
                 String eventDate, String venue,
                 double ticketPrice,
                 int totalSeats,
                 int availableSeats) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.venue = venue;
        this.ticketPrice = ticketPrice;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }
}
