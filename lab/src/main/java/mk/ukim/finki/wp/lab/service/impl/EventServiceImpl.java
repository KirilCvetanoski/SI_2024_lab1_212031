package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import mk.ukim.finki.wp.lab.model.SavedBooking;
import mk.ukim.finki.wp.lab.model.exceptions.LocationNotFoundException;
import mk.ukim.finki.wp.lab.repository.EventRepository;
import mk.ukim.finki.wp.lab.repository.LocationRepository;
import mk.ukim.finki.wp.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.searchEvents(text);
    }

    @Override
    public List<SavedBooking> getSavedBookings() {
        return eventRepository.getSavedBookings();
    }

    @Override
    public void addBooking(String evName, int numTickets) {
        eventRepository.addBooking(evName, numTickets);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> searchEventsByTextAndScore(String text, double rating) {
        return eventRepository.searchEventsByTextAndScore(text, rating);
    }

    @Override
    public List<Event> searchEventsByScore(double rating) {
        return eventRepository.searchEventsByScore(rating);
    }

    @Override
    public Optional<Event> saveEvent(Long id,String name, String description, double popularityScore, Long locationId) {

        Location location = locationRepository.findById(locationId).orElseThrow(() -> new LocationNotFoundException(locationId));

        return eventRepository.saveEvent(id,name, description, popularityScore, location);

    }



    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }
}
