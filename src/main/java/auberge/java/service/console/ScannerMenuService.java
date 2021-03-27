package auberge.java.service.console;

import auberge.java.domain.Chambre;
import auberge.java.domain.Client;
import auberge.java.domain.Location;
import auberge.java.domain.Reservation;
import auberge.java.repository.IChambreRepository;
import auberge.java.repository.IClientRepository;
import auberge.java.repository.ILocationRepository;
import auberge.java.repository.IReservationRepository;
import auberge.java.service.DisplayService;
import auberge.java.service.MenuService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ScannerMenuService implements MenuService {
    private final DisplayService displayService;
    private final Scanner scanner;
    private final ILocationRepository ilocationRepository;
    private final IReservationRepository ireservationRepository;
    private final IChambreRepository iChambreRepository;
    private final IClientRepository iClientRepository;
    DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public ScannerMenuService(DisplayService displayService, ILocationRepository ilocationRepository, IReservationRepository ireservationRepository, IChambreRepository iChambreRepository, IClientRepository iClientRepository) {
        this.displayService = displayService;
        this.ireservationRepository = ireservationRepository;
        this.iChambreRepository = iChambreRepository;
        this.iClientRepository = iClientRepository;
        this.scanner = new Scanner(System.in);
        this.ilocationRepository = ilocationRepository;
    }
    private String lireChoix() {
        return scanner.next();
    }

    //OPTIONS GENERALES
    @Override
    public int faireChoixMenu(int max) {
        int choix = -1;
        System.out.println("CHOISIR UNE OPTION");
        do {
            choix =  Integer.parseInt(scanner.nextLine());
        }while (choix < 1 && choix > max);
        return choix;
    }

    @Override
    public int faireChoixSousMenu(int max) {
        int choix = -1;
        System.out.println("CHOISIR UNE OPTION");
        do {
            choix =  Integer.parseInt(scanner.nextLine());
        }while (choix < 1 && choix > max);
        return choix;
    }

    @Override
    public void pause() {
        scanner.nextLine();
    }

    @Override
    public void ajoutChambre() {
        System.out.println("--------- AJOUT CHAMBRE -------------");
        Chambre chambre = new Chambre();
        chambre.setIdChambre(iChambreRepository.getAll().length + 1);
        chambre.setNumChambre("CH-00" + chambre.getIdChambre());
        System.out.println("SAISIR LE PRIX DE LA CHAMBRE :");
        chambre.setPrixChambre( Integer.parseInt(scanner.nextLine()));
        System.out.println("SAISIR LE STATUT DE LA CHAMBRE :");
        chambre.setStatutChambre(scanner.nextLine());
        System.out.println("SAISIR LE TYPE DE LA CHAMBRE :");
        chambre.setTypeChambre(scanner.nextLine());
        System.out.println("SAISIR LA DESCRIPTION DE LA CHAMBRE :");
        chambre.setDescriptionChambre(scanner.nextLine());
        iChambreRepository.add(chambre);
    }

    @Override
    public void supprimerChambre() {
        System.out.println("--------- SUPPRESSION CHAMBRE -------------");
        displayService.afficherListeChambres(iChambreRepository.getAll());
        System.out.println("SAISIR LE NUMERO DE LA CHAMBRE");
        String numero = scanner.nextLine();
        Chambre retrievedChambre = new Chambre();
        for (Chambre c: iChambreRepository.getAll()
             ) {
            if(c.getNumChambre().equals(numero))
            {
                retrievedChambre = c;
            }
        }
        iChambreRepository.delete(retrievedChambre);
    }

    @Override
    public Chambre rechercherChambre() {
        System.out.println("SAISIR LE NUMERO DE LA CHAMBRE RECHERCHEE");
        String numero = scanner.nextLine();
        Chambre retrievedChambre = new Chambre();
        for (Chambre c: iChambreRepository.getAll()
        ) {
            if(c.getNumChambre().equals(numero))
            {
                retrievedChambre = c;
            }
        }

        displayService.afficherChambre(retrievedChambre);
        return retrievedChambre;
    }

    @Override
    public void ajoutClient() {
        System.out.println("--------- AJOUT CLIENT -------------");
        Client client = new Client();
        client.setIdclient(iClientRepository.getAll().length + 1);
        System.out.println("SAISIR LE NOM DU CLIENT");
        client.setNomClient(scanner.nextLine());
        System.out.println("SAISIR LE PRENOM DU CLIENT");
        client.setPrenomClient(scanner.nextLine());
        System.out.println("SAISIR L'ADRESSE DU CLIENT");
        client.setAdresseClient(scanner.nextLine());
        System.out.println("SAISIR L'EMAIL DU CLIENT");
        client.setEmailClient(scanner.nextLine());
        System.out.println("SAISIR LE USERNAME DU CLIENT");
        client.setUsername(scanner.nextLine());
        System.out.println("SAISIR LE MOT DE PASSE DU CLIENT");
        client.setPassword(scanner.nextLine());
        System.out.println("SAISIR LE NUMERO DE TELEPHONE DU CLIENT");
        client.setTelClient(scanner.nextLine());
        client.setMatriculeClient("CLI-00"+client.getIdclient());
        iClientRepository.add(client);
    }

    @Override
    public void supprimerClient() {
        System.out.println("--------- SUPPRESSION CLIENT -------------");
        displayService.afficherListeChambres(iChambreRepository.getAll());
        System.out.println("SAISIR LE MATRICULE DU CLIENT");
        String matricule = scanner.nextLine();
        Client retrievedClient = new Client();
        for (Client c: iClientRepository.getAll()
        ) {
            if(c.getMatriculeClient().equals(matricule))
            {
                retrievedClient = c;
            }
        }
        iClientRepository.delete(retrievedClient);
    }

    @Override
    public Client rechercherClient() {
        System.out.println("SAISIR LE MATRICULE DU CLIENT RECHERCHE");
        String matricule = scanner.nextLine();
        Client retrievedClient = new Client();
        for (Client c: iClientRepository.getAll()
        ) {
            if(c.getMatriculeClient().equals(matricule))
            {
                retrievedClient = c;
            }
        }

        displayService.afficherClient(retrievedClient);
        return retrievedClient;
    }

    @Override
    public void ajoutReservation() {
        System.out.println("--------- AJOUT RESERVATION -------------");
        Reservation reservation = new Reservation();
        reservation.setIdReservation(ireservationRepository.getAll().length + 1);
        System.out.println("--------- CHOIX DE LA CHAMBRE --------------");
        Chambre chambre = rechercherChambre();
        reservation.setChambre(chambre.getNumChambre());
        System.out.println("--------- ENTRER LE MATRICULE DU CLIENT --------------");
        Client client = rechercherClient();
        reservation.setClient(client.getMatriculeClient());
        //System.out.println("SAISIR LA DATE DE DEPART (yyyy-MM-dd)");
        //reservation.setDateDepart(LocalDate.parse(scanner.nextLine(),df));
        System.out.println("SAISIR LA DATE D ARRIVEE (yyyy-MM-dd)");
        reservation.setDateArrivee(LocalDate.parse(scanner.nextLine(),df));
        //System.out.println("SAISIR LA DATE PAYE ARRHES (yyyy-MM-dd)");
        //reservation.setDatePayeArrhes(LocalDate.parse(scanner.nextLine(),df));
        System.out.println("SAISIR LA DATE DE RESERVATION (yyyy-MM-dd)");
        reservation.setDateReservation(LocalDate.parse(scanner.nextLine(),df));
        reservation.setNumReservation("RES-00"+reservation.getIdReservation());
        //System.out.println("SAISIR LE MONTANT DE L ARRHES");
       // reservation.setMontantArrhes(Integer.parseInt(scanner.nextLine()));
        ireservationRepository.add(reservation);
    }

    @Override
    public void supprimerReservation() {
        System.out.println("--------- SUPPRESSION RESERVATION -------------");
        displayService.afficherListeReservations(ireservationRepository.getAll());
        System.out.println("SAISIR LE NUMERO DE RESERVATION");
        String numero = scanner.nextLine();
        Reservation retrievedReservation = new Reservation();
        for (Reservation r: ireservationRepository.getAll()
        ) {
            if(r.getNumReservation().equals(numero))
            {
                retrievedReservation = r;
            }
        }
        ireservationRepository.delete(retrievedReservation);
    }

    @Override
    public Reservation rechercherReservation() {
        System.out.println("--------- SUPPRESSION RESERVATION -------------");
        displayService.afficherListeReservations(ireservationRepository.getAll());
        System.out.println("SAISIR LE NUMERO DE RESERVATION");
        String numero = scanner.nextLine();
        Reservation retrievedReservation = new Reservation();
        for (Reservation r: ireservationRepository.getAll()
        ) {
            if(r.getNumReservation().equals(numero))
            {
                retrievedReservation = r;
            }
        }
        displayService.afficherReservation(retrievedReservation);
        return retrievedReservation;
    }

    @Override
    public void ajoutLocation() {
        System.out.println("--------- AJOUT LOCATION -------------");
        Location location = new Location();
        location.setIdLocation(ilocationRepository.getAll().length + 1);
        System.out.println("--------- CHOIX DE LA CHAMBRE --------------");
        Chambre chambre = rechercherChambre();
        location.setChambre(chambre.getNumChambre());
        System.out.println("--------- ENTRER LE MATRICULE DU CLIENT --------------");
        Client client = rechercherClient();
        location.setClient(client.getMatriculeClient());
        System.out.println("SAISIR LA DATE DE DEPART (yyyy-MM-dd)");
        location.setDateDepart(LocalDate.parse(scanner.nextLine(),df));
        System.out.println("SAISIR LA DATE D ARRIVEE (yyyy-MM-dd)");
        location.setDateLocation(LocalDate.parse(scanner.nextLine(),df));
        location.setNumeroLocation("LOC-00" + location.getIdLocation());
        ilocationRepository.add(location);
    }

    @Override
    public void supprimerLocation() {
        System.out.println("--------- SUPPRESSION LOCATION -------------");
        displayService.afficherListeLocations(ilocationRepository.getAll());
        System.out.println("SAISIR LE NUMERO DE LOCATION");
        String numero = scanner.nextLine();
        Location retrievedLocation = new Location();
        for (Location l: ilocationRepository.getAll()
        ) {
            if(l.getNumeroLocation().equals(numero))
            {
                retrievedLocation = l;
            }
        }
        ilocationRepository.delete(retrievedLocation);
    }

    @Override
    public Location rechercherLocation() {
        System.out.println("--------- SUPPRESSION LOCATION -------------");
        displayService.afficherListeLocations(ilocationRepository.getAll());
        System.out.println("SAISIR LE NUMERO DE LOCATION");
        String numero = scanner.nextLine();
        Location retrievedLocation = new Location();
        for (Location l: ilocationRepository.getAll()
        ) {
            if(l.getNumeroLocation().equals(numero))
            {
                retrievedLocation = l;
            }
        }
        displayService.afficherLocation(retrievedLocation);
        return retrievedLocation;
    }
}
