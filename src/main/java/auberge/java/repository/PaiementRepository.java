package auberge.java.repository;
import auberge.java.domain.Paiement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PaiementRepository {

    public Paiement AjouterPaiement(List<Paiement> paiements)
    {
        Paiement p = new Paiement();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        p.setDatePaiement(date);
        System.out.println("SAISIR LE MONTANT PAYE");
        p.setMontantPaye(sc.nextInt());
        p.setNumPaiement("PAY-"+"00" +p.getIdPaiement());
        System.out.println("SAISIR LA DESCRIPTION DU PAIEMENT");
        p.setDescPaiement(sc.nextLine());
        paiements.add(p);
        return p;
    }

    public void AfficherListePaiement(List<Paiement> paiements)
    {
        for (Paiement p: paiements) {
            System.out.println("--------------------------------------------");
            System.out.println("NUM PAIEMENT: " + p.getNumPaiement());
            System.out.println("DATE PAIEMENT: " + p.getDatePaiement());
            System.out.println("MONTANT PAIEMENT: " + p.getMontantPaye());
            System.out.println("MONTANT PAIEMENT: " + p.getDescPaiement());
            System.out.println("--------------------------------------------");
        }
    }


    public void ModifierPaiement(List<Paiement> paiements)
    {
        Scanner sc = new Scanner(System.in);
        AfficherListePaiement(paiements);
        System.out.println("SAISIR LE NUMERO  DU PAIEMENT");
        String numero = sc.nextLine();
        for (Paiement p: paiements
        ) {
            if(p.getNumPaiement().toLowerCase().equals(numero.toLowerCase()))
            {
                SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                p.setDatePaiement(date);
                System.out.println("SAISIR LE MONTANT PAYE");
                p.setMontantPaye(sc.nextInt());
                p.setNumPaiement("PAY-"+"00" +p.getIdPaiement());
                System.out.println("SAISIR LA DESCRIPTION DU PAIEMENT");
                p.setDescPaiement(sc.nextLine());
            }
        }
    }


    public void SupprimerPaiement(List<Paiement> paiements){
        Scanner sc = new Scanner(System.in);
        AfficherListePaiement(paiements);
        System.out.println("SAISIR LE NUMERO DU PAIEMENT");
        String numero = sc.nextLine();
        for (Paiement p: paiements
        ) {
            if(p.getNumPaiement().toLowerCase().equals(numero.toLowerCase()))
            {
                paiements.remove(p);
            }
        }
    }
}

