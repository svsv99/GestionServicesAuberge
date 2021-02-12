package auberge.java.repository;

import auberge.java.domain.Chambre;
import auberge.java.domain.Location;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static auberge.java.main.main.chambres;
import static auberge.java.main.main.clients;

public class LocationRepository {
    public Location AjouterLocation(List<Location> locations)
    {
        Location l = new Location();
        Scanner sc = new Scanner(System.in);
        l.setNumeroLocation("LOC-"+"00" +l.getIdLocation());
        SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        l.setDateLocation(date);
        DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("SAISIR LA DATE DE DEPART");
        l.setDateDepart(LocalDate.parse(sc.nextLine(),df));

        //ajoutter un nouveau client
        ClientRepository clientRepository = new ClientRepository();
        l.setClient(clientRepository.ChoisirClient(clients));
        //ajouter une nouvelle chambre
        ChambreRepository chambreRepository = new ChambreRepository();
        l.setChambre(chambreRepository.ChoisirChambre(chambres));
        locations.add(l);
        return l;
    }

    public void AfficherListeLocation(List<Location> locations)
    {
        for (Location l: locations) {
            System.out.println("--------------------------------------------");
            System.out.println("NUM LOCATION: " + l.getNumeroLocation());
            System.out.println("DATE LOCATION: " + l.getDateLocation());
            System.out.println("DATE DEPART: " + l.getDateDepart());
            System.out.println("CHAMBRE LOUER: " + l.getChambre().getNumChambre());
            System.out.println("NOM CLIENT: " + l.getClient().getNomClient());
            System.out.println("--------------------------------------------");
        }
    }


    public void ModifierLocation(List<Location> locations)
    {
        Scanner sc = new Scanner(System.in);
        AfficherListeLocation(locations);
        System.out.println("SAISIR LE NUMERO DE LOCATION");
        String numero = sc.nextLine();
        for (Location l: locations
        ) {
            l.setNumeroLocation("LOC-"+"00" +l.getIdLocation());
            SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            l.setDateLocation(date);
            DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.println("SAISIR LA DATE DE DEPART");
            l.setDateDepart(LocalDate.parse(sc.nextLine(),df));
            //ajoutter un nouveau client
            ClientRepository clientRepository = new ClientRepository();
            l.setClient(clientRepository.AjouterClient(clients));
            //ajouter une nouvelle chambre
            ChambreRepository chambreRepository = new ChambreRepository();
            l.setChambre(chambreRepository.AjouterChambre(chambres));

        }
    }


    public void SupprimerLocation(List<Location> locations){
        Scanner sc = new Scanner(System.in);
        AfficherListeLocation(locations);
        System.out.println("SAISIR LE NUMERO DE LOCATION");
        String numero = sc.nextLine();
        for (Location l: locations
        ) {
            chambres.remove(l);
        }
    }
}
