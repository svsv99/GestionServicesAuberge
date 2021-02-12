package auberge.java.main;

import auberge.java.domain.*;
import auberge.java.repository.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class main {
    static DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static List<Chambre> chambres = new ArrayList<Chambre>()
    {
        {add(new Chambre("CH-001","Simple", 90000, "description1","Libre"));}
        {add(new Chambre("CH-002","Double", 120000, "description2","Libre"));}
        {add(new Chambre("CH-003","Double", 120000, "description3","Libre"));}
    };
    public static  List<Paiement> paiements = new ArrayList<Paiement>(){};
    public static  List<Facture> factures = new ArrayList<Facture>(){};
    public static  List<Consommation> consommations = new ArrayList<Consommation>()
    {
        {add(new Consommation("REP-001","RIZ POULET",3000,"Dispo"));}
        {add(new Consommation("REP-002","MAFE",2000,"Dispo"));}
        {add(new Consommation("REP-003","TIEB YAPP",4500,"Dispo"));}
    };
    public static  List<Client> clients = new ArrayList<Client>()
    {
        {add(new Client("CLIENT-001", "Salma","Djoumoi", "Dakar","salma01@gmail.com","772558877","svsv","passer"));}
        {add(new Client("CLIENT-002", "Diop","Mamadou", "Dakar","mamadou02@gmail.com","775554488","mamadou","passer"));}
        {add(new Client("CLIENT-003", "Salma","Djoumoi", "Dakar","salma01@gmail.com","772558877","svsv02","passer"));}

    };
    public static List<Location> locations = new ArrayList<Location>(){
        {add(new Location("LOC-001",new Date(System.currentTimeMillis()),LocalDate.parse("09/02/2021", df),chambres.get(0),clients.get(0)));}
    };
    public static  List<Reservation> reservations = new ArrayList<Reservation>()
    {
        {
            try {
                add(new Reservation("RSV-01", new Date(System.currentTimeMillis()), LocalDate.parse("09/02/2021", df),
                        LocalDate.parse("10/02/2021", df), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2021"), 100000, false, chambres.get(0),
                        clients.get(0)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    };


    static int choixMenu;

    public static void main(String[] args) {
        AfficherSousMenu(AfficherMenuPrincipal());
    }
    public static int AfficherMenuPrincipal()
    {
        while(choixMenu != 7)
        {
            clrscr();
            Scanner in = new Scanner(System.in);
            System.out.println("----MENU----");
            System.out.println("1.GESTION RESERVATION");
            System.out.println("2.GESTION PAIEMENT");
            System.out.println("3.GESTION CHAMBRES");
            System.out.println("4.GESTION LOCATION");
            System.out.println("5.GESTION FACTURATION");
            System.out.println("6.GESTION CONSOMMATION");
            System.out.println("7.QUITTER");
            System.out.println(("FAITES VOTRE CHOIX"));
            do{
                choixMenu = in.nextInt();
            }while(choixMenu < 1 || choixMenu > 7);
            if(choixMenu != 7)
            {
                return choixMenu;
            }
        }
        return 0;
    }

    public static void AfficherSousMenu(int index)
    {
        while(index >= 1  && index <= 6)
        {
            switch (index)
            {
                case 1:
                    //afficher sous menu Reservation
                    GererReservation();
                    break;
                case 2:
                    //afficher sous menu Paiement
                    GererPaiement();
                    break;
                case 3:
                    //afficher sous menu chambres
                    GererChambres();
                    break;
                case 4:
                    //afficher sous menu location
                    GererLocation();
                    break;
                case 5:
                    //afficher sous menu facturation
                    GererFacturation();
                case 6:
                    //afficher sous menu consommation
                    GererConsommation();
                    break;
                default:
                    //afficher msg
                    System.out.println("Vous venez de quitter l'application à Bientot !");
                    break;
            }
        }
    }

    public static void GererPaiement()
    {
        Scanner in = new Scanner(System.in);
        int choix;
        System.out.println("MENU PAIEMENT");
        System.out.println("1.EFFECTUER UN PAIEMENT");
        System.out.println("2.AFFICHER LISTE PAIEMENT");
        System.out.println("3.MODIFIER UN PAIEMENT");
        System.out.println("4.RETOUR");
        System.out.println("5.QUITTER");
        System.out.println(("FAITES VOTRE CHOIX"));
        do{
            choix = in.nextInt();
        }while(choix < 1 || choix > 5);
        PaiementRepository paiementRepository = new PaiementRepository();
        switch (choix)
        {
            case 1:
                //gerer l ajout
                paiementRepository.AjouterPaiement(paiements);
                break;
            case 2:
                //gerer affichage
                paiementRepository.AfficherListePaiement(paiements);

                break;
            case 3:
                //gerer modifier
                paiementRepository.ModifierPaiement(paiements);
                break;
            case 4:
                //gerer retour
                clrscr();
                AfficherSousMenu(AfficherMenuPrincipal());
                break;
            case 5:
                //gerer quitter
                return;
            default:
                //gerer choix non disponible
                break;
        }

    }
    public static void GererReservation()
    {
        Scanner in = new Scanner(System.in);
        int choix;
        System.out.println("MENU RESERVATION");
        System.out.println("1.EFFECTUER UNE RESERVATION");
        System.out.println("2.MODIFIER UNE RESERVATION");
        System.out.println("3.AFFICHER LES RESERVATION");
        System.out.println("4.SUPPRIMER UNE RESERVATION");
        System.out.println("5.RETOUR");
        System.out.println("6.QUITTER");
        System.out.println(("FAITES VOTRE CHOIX"));
        do{
            choix = in.nextInt();
        }while(choix < 1 || choix > 6);
        ReservationRepository reservationRepository = new ReservationRepository();

        switch (choix)
        {
            case 1:
                //gerer l ajout
                reservationRepository.AjouterReservation(reservations);
                break;
            case 2:
                //gerer modifier
                reservationRepository.ModifierReservation(reservations);

                break;
            case 3:
                //gerer Affichage
                reservationRepository.AfficherListeReservation(reservations);
                break;
            case 4:
                //gerer Suppression
                reservationRepository.SupprimerReservation(reservations);
                break;
            case 5:
                //gerer retour
                clrscr();
                AfficherSousMenu(AfficherMenuPrincipal());
                break;
            case 6:
                //gerer quitter
                return;
            default:
                //gerer choix non disponible
                break;
        }

    }

    public static void GererChambres()
    {
        Scanner in = new Scanner(System.in);
        int choix;
        System.out.println("MENU CHAMBRE");
        System.out.println("1.AJOUTER UNE CHAMBRE");
        System.out.println("2.AFFICHER UNE CHAMBRE");
        System.out.println("3.MODIFIER UNE CHAMBRE");
        System.out.println("4.RETOUR");
        System.out.println("5.QUITTER");
        System.out.println(("FAITES VOTRE CHOIX"));
        do{
            choix = in.nextInt();
        }while(choix < 1 || choix > 5);
        ChambreRepository chambreRepository = new ChambreRepository();
        switch (choix)
        {
            case 1:
                //gerer l ajout
                chambreRepository.AjouterChambre(chambres);
                break;
            case 2:
                //gerer Affichage
                chambreRepository.AfficherListeChambre(chambres);
                break;
            case 3:
                //gerer Modification
                chambreRepository.ModifierChambre(chambres);
                break;
            case 4:
                //gerer retour
                clrscr();
                AfficherSousMenu(AfficherMenuPrincipal());
                break;
            case 5:
                //gerer quitter
                return;
            default:
                //gerer choix non disponible
                break;
        }

    }

    public static void GererLocation()
    {
        Scanner in = new Scanner(System.in);
        int choix;
        System.out.println("MENU LOCATION");
        System.out.println("1.EFFECTUER UNE LOCATION");;
        System.out.println("2.AFFICHER LISTE DES LOCATIONS");
        System.out.println("3.MODIFIER UNE LOCATION");
        System.out.println("4.RETOUR");
        System.out.println("5.QUITTER");
        System.out.println(("FAITES VOTRE CHOIX"));
        do{
            choix = in.nextInt();
        }while(choix < 1 || choix > 5);

        LocationRepository locationRepository = new LocationRepository();
        switch (choix)
        {
            case 1:
                //gerer l ajout
             locationRepository.AjouterLocation(locations);
                break;
            case 2:
                //gerer affichage
                locationRepository.AfficherListeLocation(locations);
                break;
            case 3:
                //gerer modification
                locationRepository.ModifierLocation(locations);
                break;
            case 4:
                //gerer retour
                clrscr();
                AfficherSousMenu(AfficherMenuPrincipal());
                break;
            case 5:
                //gerer quitter
                return;
            default:
                //gerer choix non disponible
                break;
        }

    }

    public static void GererFacturation()
    {
        Scanner in = new Scanner(System.in);
        int choix;
        System.out.println("MENU FACTURATION");
        System.out.println("1.AJOUTER UNE FACTURE");;
        System.out.println("2.AFFICHER LISTE FACTURE");
        System.out.println("3.MODIFIER UNE FACTURE");
        System.out.println("4.RETOUR");
        System.out.println("5.QUITTER");
        System.out.println(("FAITES VOTRE CHOIX"));
        do{
            choix = in.nextInt();
        }while(choix < 1 || choix > 5);
        FactureRepository factureRepository = new FactureRepository();
        switch (choix)
        {
            case 1:
                //gerer l ajout
                factureRepository.AjouterFacture(factures);
                break;
            case 2:
                //gerer affichage
                factureRepository.AfficherListeFacture(factures);
                break;
            case 3:
                //gerer modification
                factureRepository.ModifierFacture(factures);
                break;
            case 4:
                //gerer retour
                clrscr();
                AfficherSousMenu(AfficherMenuPrincipal());
                break;
            case 5:
                //gerer quitter
                return;
            default:
                //gerer choix non disponible
                break;
        }

    }


    public static void GererConsommation()
    {
        Scanner in = new Scanner(System.in);
        int choix;
        System.out.println("MENU CONSOMMATION");
        System.out.println("1.AJOUTER UN CONSOMMABLE");;
        System.out.println("2.AFFICHER UN CONSOMMABLE");
        System.out.println("3.MODIFIER UN CONSOMMABLE");
        System.out.println("4.RETOUR");
        System.out.println("5.QUITTER");
        System.out.println(("FAITES VOTRE CHOIX"));
        do{
            choix = in.nextInt();
        }while(choix < 1 || choix > 5);
        ConsommationRepository consommationRepository = new ConsommationRepository();

        switch (choix)
        {
            case 1:
                //gerer l ajout
                consommationRepository.AjouterConsommable(consommations);
                break;
            case 2:
                //gerer l'affichage
                consommationRepository.AfficherListeConsommable(consommations);

                break;
            case 3:
                //gerer modifcation
                consommationRepository.ModifierConsommation(consommations);
                break;
            case 4:
                //gerer retour
                clrscr();
                AfficherSousMenu(AfficherMenuPrincipal());
                break;
            case 5:
                //gerer quitter
                return;
            default:
                //gerer choix non disponible
                break;
        }

    }

    public static void clrscr(){

        //Clears Screen in java

        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {}

    }
}
