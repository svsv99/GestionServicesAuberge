package auberge.java.repository;

import auberge.java.domain.Location;

public interface ILocationRepository {
    Location[] getAll();
    Location getById(int id);
    void add(Location location);
    void delete(Location location);
}
