package mk.ukim.finki.wp.lab.repository;


import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Location;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepository {
    List<Location> locations;
    public LocationRepository() {
        locations = new ArrayList<Location>();
        locations.add(new Location("Something1", "Address1", "200", "fenwfnowifenwifnoiwfnwoiefn"));
        locations.add(new Location("Something2", "Address2", "100", "Bulevar 21ew"));
        locations.add(new Location("Something3", "Address3", "150", "Bgregegwqedd"));
        locations.add(new Location("Something4", "Address4", "150", "dbiafufbiqwbfbfiq"));
        locations.add(new Location("Something5", "Address5", "250", "sadafgfw"));
    }
    //    public List<Location> findAll() {
    //        return DataHolder.locations;
    //    }
    public Optional<Location> findById(Long id) {
        return DataHolder.locations.stream().filter(i -> i.getId().equals(id)).findFirst();
    }
    public List<Location> findAll(){
        return locations;
    }

}
