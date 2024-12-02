package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Event;

import mk.ukim.finki.wp.lab.model.SavedBooking;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
    List<SavedBooking> getSavedBookings();
    void addBooking(String evName, int numTickets);
    Optional<Event> findById(Long id);
    List<Event> searchEventsByTextAndScore(String text, double rating);
    List<Event> searchEventsByScore(double rating);
    Optional<Event> saveEvent(Long id,String name, String description, double popularityScore, Long locationId);
    void deleteById(Long id);
}
