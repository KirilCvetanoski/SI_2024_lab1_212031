package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.EventBooking;

import java.util.List;

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
    void addBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);

    List<EventBooking> listAll();

    public List<EventBooking> searchEventsByEventName(String text);
    public List<EventBooking> searchEventsByAtendeeName(String name);
    public List<EventBooking> searchEventsByNumTickets(int tickets);
    public List<EventBooking> searchEvent(String eventName,String atendeeName,int tickets);
}
