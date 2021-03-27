package auberge.java.service.console;

import auberge.java.domain.Chambre;
import auberge.java.domain.Client;
import auberge.java.domain.Location;
import auberge.java.domain.Reservation;
import auberge.java.service.DisplayService;

public class ConsoleDisplayService implements DisplayService {
    // OPTION MENU PRINCIPAM
    @Override
    public void afficherBienvenu() {
        System.out.println("---------------BIENVENUE DANS NOTRE PLATEFORME DE RESERVATION DE CHAMBRE---------------");
    }

    @Override
    public void afficherMenuPrincipal() {
        System.out.println("------------------- MENU PRINCIPAL -----------------------------------");
        System.out.println("1................. GESTION DES CHAMBRES");
        System.out.println("2................. GESTION DES CLIENTS");
        System.out.println("3................. GESTION DES RESERVATIONS");
        System.out.println("4................. GESTION DES LOCATIONS");
        System.out.println("5................. QUITTER");
    }

    @Override
    public void afficherMenuChambre() {
        System.out.println("------------------- GESTION DES CHAMBRES -----------------------------------");
        System.out.println("1................. AJOUT CHAMBRE");
        System.out.println("2................. LISTE DES CHAMBRES");
        System.out.println("3................. RECHERCHER CHAMBRE");
        System.out.println("4................. SUPPRESSION CHAMBRE");
        System.out.println("5................. RETOUR");
    }

    @Override
    public void afficherMenuClient() {
        System.out.println("------------------- GESTION DES CLIENTS -----------------------------------");
        System.out.println("1................. AJOUT CLIENT");
        System.out.println("2................. LISTE DES CLIENTS");
        System.out.println("3................. RECHERCHER CLIENT");
        System.out.println("4................. SUPPRESSION CLIENT");
        System.out.println("5................. RETOUR");
    }

    @Override
    public void afficherMenuReservation() {
        System.out.println("------------------- GESTION DES RESERVATIONS -----------------------------------");
        System.out.println("1................. AJOUT RESERVATION");
        System.out.println("2................. LISTE DES RESERVATIONS");
        System.out.println("3................. RECHERCHER RESERVATION");
        System.out.println("4................. SUPPRESSION RESERVATION");
        System.out.println("5................. RETOUR");
    }

    @Override
    public void afficherMenuLocation() {
        System.out.println("------------------- GESTION DES LOCATIONS -----------------------------------");
        System.out.println("1................. AJOUT LOCATION");
        System.out.println("2................. LISTE DES LOCATIONS");
        System.out.println("3................. RECHERCHER LOCATION");
        System.out.println("4................. SUPPRESSION LOCATION");
        System.out.println("5................. RETOUR");
    }

    @Override
    public void afficherOptionInconnue() {
        System.out.println("CHOIX NON DISPONIBLE");
    }

    //OPTIONS MENU CHAMBRE

    @Override
    public void afficherListeChambres(Chambre[] chambres) {
        for (Chambre c: chambres
             ) {
            afficherChambre(c);
        }
    }

    @Override
    public void afficherChambre(Chambre chambre) {
        System.out.println("-------------------------------------------");
        System.out.println("NUMERO CHAMBRE: " + chambre.getNumChambre());
        System.out.println("DESCRIPTION CHAMBRE: " + chambre.getDescriptionChambre());
        System.out.println("PRIX CHAMBRE: " + chambre.getPrixChambre());
        System.out.println("STATUT CHAMBRE: " + chambre.getStatutChambre());
        System.out.println("TYPE CHAMBRE: " + chambre.getTypeChambre());
        System.out.println("-------------------------------------------");
    }
    //OPTIONS MENU CLIENT
    @Override
    public void afficherListeClients(Client[] clients) {
        for (Client c: clients
             ) {
            afficherClient(c);
        }
    }

    @Override
    public void afficherClient(Client client) {
        System.out.println("-------------------------------------------");
        System.out.println("MATRICULE CLIENT: " + client.getMatriculeClient());
        System.out.println("NOM CLIENT: " + client.getNomClient());
        System.out.println("PRENOM CLIENT: " + client.getPrenomClient());
        System.out.println("TEL CLIENT: " + client.getTelClient());
        System.out.println("ADRESSE CLIENT: " + client.getAdresseClient());
        System.out.println("EMAIL CLIENT: " + client.getEmailClient());
        System.out.println("-------------------------------------------");
    }
    //OPTIONS MENU RESERVATION
    @Override
    public void afficherListeReservations(Reservation[] reservations) {
        for (Reservation r : reservations
             ) {
            afficherReservation(r);
        }
    }

    @Override
    public void afficherReservation(Reservation reservation) {
        System.out.println("-------------------------------------------");
        System.out.println("NUMERO RESERVATION: " + reservation.getNumReservation());
        System.out.println("DATE ARRIVEE: " + reservation.getDateArrivee());
        System.out.println("DATE RESERVATION: " + reservation.getDateReservation());
        //System.out.println("DATE DEPART: " + reservation.getDateDepart());
       // System.out.println("DATE PAYE ARRHES: " + reservation.getDatePayeArrhes());
       // System.out.println("MONTANT ARRHES: " + reservation.getMontantArrhes());
        System.out.println("CHAMBRE: " + reservation.getChambre());
        System.out.println("CLIENT: " + reservation.getClient());
        System.out.println("-------------------------------------------");
    }
    //OPTIONS MENU LOCATION
    @Override
    public void afficherListeLocations(Location[] locations) {
        for (Location l: locations
             ) {
            afficherLocation(l);
        }
    }

    @Override
    public void afficherLocation(Location location) {
        System.out.println("-------------------------------------------");
        System.out.println("NUMERO LOCATION: " + location.getNumeroLocation());
        System.out.println("DATE LOCATION: " + location.getDateLocation());
        System.out.println("DATE DEPART: " + location.getDateDepart());
        System.out.println("CLIENT: " + location.getClient());
        System.out.println("CHAMBRE: " + location.getChambre());
        System.out.println("-------------------------------------------");
    }
}
