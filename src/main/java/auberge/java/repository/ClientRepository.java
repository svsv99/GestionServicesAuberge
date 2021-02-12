package auberge.java.repository;

import auberge.java.domain.Chambre;
import auberge.java.domain.Client;

import java.util.List;
import java.util.Scanner;

public class ClientRepository {

    public Client AjouterClient(List<Client> clients)
    {
        Client cl = new Client();
        Scanner sc = new Scanner(System.in);
        cl.setMatriculeClient("CL-"+"00" +cl.getIdclient());
        System.out.println("SAISIR LE NOM DU CLIENT");
        cl.setNomClient(sc.nextLine());
        System.out.println("SAISIR LE PRENOM DU CLIENT");
        cl.setPrenomClient(sc.nextLine());
        System.out.println("SAISIR LE TELEPHONE DU CLIENT");
        cl.setNomClient(sc.nextLine());
        System.out.println("SAISIR LE MAIL DU CLIENT");
        cl.setEmailClient(sc.nextLine());
        System.out.println("SAISIR L ADRESSE DU CLIENT");
        cl.setAdresseClient(sc.nextLine());
        clients.add(cl);
        return cl;
    }

    public void AfficherListeClient(List<Client> clients)
    {
        for (Client cl: clients) {
            System.out.println("--------------------------------------------");
            System.out.println("MATRICULE CLIENT: " + cl.getMatriculeClient());
            System.out.println("NOM CLIENT: " + cl.getNomClient());
            System.out.println("PRENOM CLIENT: " + cl.getPrenomClient());
            System.out.println("ADRESSE CLIENT: " + cl.getAdresseClient());
            System.out.println("TEL CLIENT: " + cl.getTelClient());
            System.out.println("EMAIL CLIENT: " + cl.getEmailClient());
            System.out.println("--------------------------------------------");
        }
    }


    public void ModifierClient(List<Client> clients)
    {
        Scanner sc = new Scanner(System.in);
        AfficherListeClient(clients);
        System.out.println("SAISIR LE MATRICULE DU CLIENT");
        String matricule = sc.nextLine();
        for (Client c: clients
        ) {
            if(c.getMatriculeClient().toLowerCase().equals(matricule.toLowerCase()))
            {
                System.out.println("SAISIR LE NOM DU CLIENT");
                c.setNomClient(sc.nextLine());
                System.out.println("SAISIR LE PRENOM DU CLIENT");
                c.setPrenomClient(sc.nextLine());
                System.out.println("SAISIR LE TELEPHONE DU CLIENT");
                c.setNomClient(sc.nextLine());
                System.out.println("SAISIR LE MAIL DU CLIENT");
                c.setEmailClient(sc.nextLine());
                System.out.println("SAISIR L ADRESSE DU CLIENT");
                c.setAdresseClient(sc.nextLine());
            }
        }
    }


    public void SupprimerClient(List<Client> clients){
        Scanner sc = new Scanner(System.in);
        AfficherListeClient(clients);
        System.out.println("SAISIR LE MATRICULE DU CLIENT");
        String matricule = sc.nextLine();
        for (Client c: clients
        ) {
            if(matricule.toLowerCase().equals(c.getMatriculeClient().toLowerCase()))
            {
                clients.remove(c);
            }
        }
    }
    public Client ChoisirClient(List<Client> clients){
        Scanner sc = new Scanner(System.in);
        AfficherListeClient(clients);
        System.out.println("SAISIR Le MATRICULE DU CLIENT CHOISIE");
        String numero = sc.nextLine();
        for (Client cl: clients
        ) {
            if(cl.getMatriculeClient().toLowerCase().equals(numero.toLowerCase())) {
                return cl;
            }
        }
        return null;
    }
}
