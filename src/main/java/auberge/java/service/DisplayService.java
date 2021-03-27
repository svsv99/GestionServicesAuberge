package auberge.java.service;

import auberge.java.domain.Chambre;
import auberge.java.domain.Client;
import auberge.java.domain.Location;
import auberge.java.domain.Reservation;

public interface DisplayService {
    void afficherBienvenu();
    //Menu Genaral
    void afficherMenuPrincipal();
    void afficherMenuChambre();
    void afficherMenuClient();
    void afficherMenuReservation();
    void afficherMenuLocation();
    void afficherOptionInconnue();
    //Options menu chambre
    void afficherListeChambres(Chambre[] chambres);
    void afficherChambre(Chambre chambre);
    //Options menu client
    void afficherListeClients(Client[] clients);
    void afficherClient(Client client);
    //Options menu reservation
    void afficherListeReservations(Reservation[] reservations);
    void afficherReservation(Reservation reservation);
    //Options menu location
    void afficherListeLocations(Location[] locations);
    void afficherLocation(Location location);
}
