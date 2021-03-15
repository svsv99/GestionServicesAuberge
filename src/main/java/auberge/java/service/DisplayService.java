package auberge.java.service;

import auberge.java.domain.Location;
import auberge.java.domain.Reservation;

public interface DisplayService {
    void afficherBienvenu();

    void afficherMenuPrincipal();

    void afficherListeLocation(Location[] locations);
    void afficherListeReservation(Reservation[] reservations);

    void afficherOptionInconnue();

}
