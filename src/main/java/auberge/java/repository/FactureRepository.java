package auberge.java.repository;

import auberge.java.domain.Facture;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FactureRepository {

    public Facture AjouterFacture(List<Facture> factures)
    {
        Facture f = new Facture();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        f.setDateFacture(date);
        System.out.println("SAISIR LE MONTANT DE LA FACTURE");
        f.setMontant(sc.nextInt());
        f.setNumFacture("CH-"+"00" +f.getNumFacture());
        factures.add(f);
        return f;
    }

    public void AfficherListeFacture(List<Facture> factures)
    {
        for (Facture f: factures) {
            System.out.println("--------------------------------------------");
            System.out.println("NUM F: " + f.getNumFacture());
            System.out.println("DATE FACTURE: " + f.getDateFacture());
            System.out.println("MONTANT FACTURE: " + f.getMontant());
            System.out.println("--------------------------------------------");
        }
    }


    public void ModifierFacture(List<Facture> factures)
    {
        Scanner sc = new Scanner(System.in);
        AfficherListeFacture(factures);
        System.out.println("SAISIR le numero DE LA FACTURE");
        String numero = sc.nextLine();
        for (Facture f: factures
        ) {
            if(f.getNumFacture().toLowerCase().equals(numero.toLowerCase()))
            {
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                f.setDateFacture(date);
                System.out.println("SAISIR LE MONTANT DE LA FACTURE");
                f.setMontant(sc.nextInt());
                f.setNumFacture("CH-"+"00" +f.getNumFacture());
            }
        }
    }


    public void SupprimerFacture(List<Facture> factures){
        Scanner sc = new Scanner(System.in);
        AfficherListeFacture(factures);
        System.out.println("SAISIR le numero DE LA FACTURE");
        String numero = sc.nextLine();
        for (Facture f: factures
        ) {
            if(f.getNumFacture().toLowerCase().equals(numero.toLowerCase()))
            {
                factures.remove(f);
            }
        }
    }
}
