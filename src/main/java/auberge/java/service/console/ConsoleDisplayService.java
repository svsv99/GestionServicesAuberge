package auberge.java.service.console;

import auberge.java.domain.Location;
import auberge.java.domain.Reservation;
import auberge.java.service.DisplayService;

public class ConsoleDisplayService implements DisplayService {
    @Override
    public void afficherBienvenu() {
        System.out.println("Bienvenue sur la plateforme Service d'Auberge !!!");

    }

    @Override
    public void afficherMenuPrincipal() {
        /*System.out.println("> Tapez ll pour afficher la liste des locations actuelle ");
        System.out.println("> Tapez lr pour afficher la liste des locations actuelle ");

         */

        System.out.println("--------------MENU---------------");
        System.out.println("1.AFFICHAGE LISTE DES LOCATION");
        //System.out.println("2.RECHERCHE D'UNE LOCATION");
        System.out.println("2.AFFICHAGE LISTE DES RESERVATION");

    }

    @Override
    public void afficherListeLocation(Location[] locations) {
        System.out.println("La liste des locations actuels est la suivante :");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < locations.length; i++) {
            Location location = locations[i];
            System.out.println(String.format("> ID:%s NUMERO_LOCATION:%s DATE_LOCATION:%s DATE_DEPART:%s CHAMBRE:%s  CLIENT:%s ",
                    location.getIdLocation(), location.getNumeroLocation(),location.getDateLocation(),location.getDateDepart(),location.getChambre(),location.getClient()));
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }
    public void afficherListeReservation(Reservation[] reservations) {
        System.out.println("La liste des reservations actuels est la suivante:");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < reservations.length; i++) {
            Reservation reservation = reservations[i];
            System.out.println(String.format("> ID:%s NUMERO_RESERVATION:%s DATE_RESERVATION:%s DATE_ARRIVEE:%s CHAMBRE:%s CLIENT:%s",
                    reservation.getIdReservation(),reservation.getNumReservation(),reservation.getDateReservation(),
                    reservation.getDateArrivee(),reservation.getChambre(),reservation.getClient()));
        }
        System.out.println("-------------------------------------------------------------------------------------");

    }


    @Override
    public void afficherOptionInconnue() {
        System.out.println("Choix inconnu");

    }
}
