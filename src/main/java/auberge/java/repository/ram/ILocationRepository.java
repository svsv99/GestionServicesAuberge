package auberge.java.repository.ram;

import auberge.java.domain.Location;

public interface ILocationRepository {
    Location[] getAll();
    Location getById(int id);
}
