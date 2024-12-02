package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import mk.ukim.finki.wp.lab.model.SavedBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class  EventRepository {

    private List<SavedBooking> savedBookings = new ArrayList<>();

    public List<Event> findAll(){
        return DataHolder.eventList;
    }

    public Optional<Event> findById(Long id) {
        return DataHolder.events.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public List<Event> searchEvents(String text) {
        return DataHolder.eventList.stream()
                .filter(event -> event.getName().toLowerCase().contains(text.toLowerCase()) ||
                        event.getDescription().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<SavedBooking> getSavedBookings() {
        return savedBookings;
    }
    public List<Event> searchEventsByTextAndScore(String text, double rating) {
        return DataHolder.events.stream().filter(i -> i.getName().toLowerCase().contains(text.toLowerCase()) && i.getPopularityScore() <= rating).collect(Collectors.toList());
    }


    public List<Event> searchEventsByScore(double rating) {
        return DataHolder.events.stream().filter(i -> i.getPopularityScore() <= rating).collect(Collectors.toList());
    }

    public void deleteById(Long id) {

        int a = 0;
        DataHolder.events.removeIf(i -> i.getId().equals(id));
    }

    public Optional<Event> saveEvent(Long id, String name, String description, double popularityScore, Location location) {


        if (id != null) {
            Optional<Event> optionalEvent = findById(id);
            if (optionalEvent.isPresent()) {
                Event event = optionalEvent.get();
                event.setName(name);
                event.setDescription(description);
                event.setPopularityScore(popularityScore);
                event.setLocation(location);
                return Optional.of(event);
            }


        }

        DataHolder.events.removeIf(i -> i.getName().equals(name));

        Event event = new Event(name, description, popularityScore, location);
        DataHolder.events.add(event);
        return Optional.of(event);

    }
    public void addBooking(String evName, int numTickets) {
        boolean bookinExists = false;
        for (SavedBooking booking : savedBookings) {
            if (booking.getEventName().equals(evName)) {
                booking.setNumberOfTickets(booking.getNumberOfTickets() + numTickets);
                bookinExists = true;
                break;
            }
        }

        if (!bookinExists) {
            savedBookings.add(new SavedBooking(evName, numTickets));
        }
    }


}
