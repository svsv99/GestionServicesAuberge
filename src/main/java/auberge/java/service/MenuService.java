package auberge.java.service;

import auberge.java.domain.Chambre;
import auberge.java.domain.Client;
import auberge.java.domain.Location;
import auberge.java.domain.Reservation;

public interface MenuService {

    //OPTIONS GENERALES
    int faireChoixMenu(int max);
    int faireChoixSousMenu(int max);
    void pause();
    //OPTIONS CHAMBRES
    void ajoutChambre();
    void supprimerChambre();
    Chambre rechercherChambre();
    //OPTIONS CLIENTS
    void ajoutClient();
    void supprimerClient();
    Client rechercherClient();
    //OPTIONS RESERVATIONS
    void ajoutReservation();
    void supprimerReservation();
    Reservation rechercherReservation();
    //OPTIONS LOCATIONS
    void ajoutLocation();
    void supprimerLocation();
    Location rechercherLocation();

}
