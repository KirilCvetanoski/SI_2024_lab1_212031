package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.EventBooking;
import mk.ukim.finki.wp.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = new ArrayList<>();
    public static List<EventBooking> eventBookingList = new ArrayList<>();
    public static List<Location> locations = new ArrayList<>();
    public static List<Event> eventList = new ArrayList<>();

    @PostConstruct
    public void init() {
        eventList.add(new Event("Event1", "Desc1", 10.00, new Location("Something1", "Address1", "200", "Description1")));
        eventList.add(new Event("Event2", "Desc2", 7.30, new Location("Something2", "Address2", "201", "description2")));
        eventList.add(new Event("Event3", "Desc3", 10.00, new Location("Something3", "Address3", "202", "description3")));
        eventList.add(new Event("Event4", "Desc4", 9.25, new Location("Something4", "Address4", "203", "description4")));
        eventList.add(new Event("Event5", "Desc5", 6.75, new Location("Something5", "Address5", "204", "description5")));
        eventList.add(new Event("Event6", "Desc6", 7.45, new Location("Something6", "Address6", "205", "description6")));
        eventList.add(new Event("Event7", "Desc7", 2.15, new Location("Something7", "Address7", "206", "description7")));
        eventList.add(new Event("Event8", "Desc8", 1.45, new Location("Something8", "Address8", "207", "description8")));
        eventList.add(new Event("Event9", "Desc9", 1.00, new Location("Something9", "Address9", "208", "description9")));
        eventList.add(new Event("Event10", "Desc10", 10.00, new Location("Something10", "Address10", "209", "description10")));
    }
}