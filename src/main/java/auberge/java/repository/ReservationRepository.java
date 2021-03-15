package auberge.java.repository;

import auberge.java.domain.Reservation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static auberge.java.main.Main.*;
//import static auberge.java.main.Main.chambres;

public class ReservationRepository {

    /*public Reservation AjouterReservation(List<Reservation> reservations)
    {
        Reservation r = new Reservation();
        Scanner sc = new Scanner(System.in);
        r.setNumReservation("RSV-"+"00" +r.getNumReservation());
        r.setMontantArrhes(r.getMontantArrhes());
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        r.setDateReservation(date);
        DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("SAISIR LA DATE D ARRIVE");
        r.setDateArrivee(LocalDate.parse(sc.nextLine(),df));
        System.out.println("SAISIR LA DATE DEPART");
        r.setDateDepart(LocalDate.parse(sc.nextLine(),df));

        //ajoutter un nouveau client
        ClientRepository clientRepository = new ClientRepository();
        r.setClient(clientRepository.ChoisirClient(clients));
        //ajouter une nouvelle chambre
        ChambreRepository chambreRepository = new ChambreRepository();
        r.setChambre(chambreRepository.ChoisirChambre(chambres));
        reservations.add(r);
        return r;
    }


    public void AfficherListeReservation(List<Reservation> reservations)
    {
        for (Reservation r: reservations) {
            System.out.println("--------------------------------------------");
            System.out.println("NUM RESERVATION: " + r.getNumReservation());
            System.out.println("DATE RESERVATION: " + r.getDateReservation());
            System.out.println("DATE ARRIVEE: " + r.getDateArrivee());
            System.out.println("DATE DEPART: " + r.getDateDepart());
            System.out.println("MONTANT CAUTION: " + r.getMontantArrhes());
            System.out.println("CHAMBRE RESERVE: " + r.getChambre().getNumChambre());
            System.out.println("NOM CLIENT: " + r.getClient().getNomClient());
            System.out.println("--------------------------------------------");
        }
    }


    /*public void ModifierReservation(List<Reservation> reservations)
    {
        Scanner sc = new Scanner(System.in);
        AfficherListeReservation(reservations);
        System.out.println("SAISIR LE NUMERO DE RESERVATION");
        String numero = sc.nextLine();
        for (Reservation r: reservations
        ) {
            r.setNumReservation("RSV-"+"00" +r.getNumReservation());
            r.setMontantArrhes(r.getMontantArrhes());
            SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            r.setDateReservation(date);
            DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("SAISIR LA DATE D ARRIVE");
            r.setDateArrivee(LocalDate.parse(sc.nextLine(),df));
            System.out.println("SAISIR LA DATE DEPART");
            r.setDateDepart(LocalDate.parse(sc.nextLine(),df));

            //ajoutter un nouveau client
            ClientRepository clientRepository = new ClientRepository();
            r.setClient(clientRepository.ChoisirClient(clients));
            //ajouter une nouvelle chambre
            ChambreRepository chambreRepository = new ChambreRepository();
            r.setChambre(chambreRepository.ChoisirChambre(chambres));
        }
    }




    public void SupprimerReservation(List<Reservation> reservations){
        Scanner sc = new Scanner(System.in);
        AfficherListeReservation(reservations);
        System.out.println("SAISIR LE NUMERO DE RESERVATION");
        String numero = sc.nextLine();
        for (Reservation r: reservations
        ) {
            reservations.remove(r);
        }
    }

     */
}
