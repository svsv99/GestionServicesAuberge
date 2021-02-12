package auberge.java.repository;
import auberge.java.domain.Consommation;

import java.util.List;
import java.util.Scanner;

public class ConsommationRepository {
    public void AjouterConsommable(List<Consommation> consommations)
    {
        Consommation cons = new Consommation();
        Scanner sc = new Scanner(System.in);
        cons.setNumConsommation("C-"+"00" +cons.getIdConsommation());
        System.out.println("SAISIR LE LIBELLE DU CONSOMMABLE");
        cons.setLibelleConsommation(sc.nextLine());
        System.out.println("SAISIR LE PRIX DU CONSOMMABLE");
        cons.setPuConsommation(sc.nextInt());
        System.out.println("SAISIR LE STATUT DU CONSOMMABLE");
        cons.setStatutConsommation(sc.nextLine());
        consommations.add(cons);
    }
    public void AfficherListeConsommable(List<Consommation> consommations)
        {
            for (Consommation con: consommations)
            {
                System.out.println("--------------------------------------------");
                System.out.println("NUMERO REPAS/BOISSON: " + con.getNumConsommation());
                System.out.println("LIBELLE REPAS/BOISSON: " + con.getLibelleConsommation());
                System.out.println("PRIX REPAS/BOISSON: " + con.getPuConsommation());
                System.out.println("STATUT REPAS/BOISSON: " + con.getStatutConsommation());
                System.out.println("--------------------------------------------");
            }
        }

    public void ModifierConsommation(List<Consommation> consommations)
    {
        Scanner sc = new Scanner(System.in);
        AfficherListeConsommable(consommations);
        System.out.println("SAISIR le NUMERO DU CONSOMMABLE");
        String numero = sc.nextLine();
        for (Consommation cons: consommations
        ) {
            cons.setNumConsommation("C-"+"00" +cons.getIdConsommation());
            System.out.println("SAISIR LE LIBELLE DU CONSOMMABLE");
            cons.setLibelleConsommation(sc.nextLine());
            System.out.println("SAISIR LE PRIX DU CONSOMMABLE");
            cons.setPuConsommation(sc.nextInt());
            System.out.println("SAISIR LE STATUT DU CONSOMMABLE");
            cons.setStatutConsommation(sc.nextLine());
        }
    }
    public void SupprimerConsommable(List<Consommation> consommations){
        Scanner sc = new Scanner(System.in);
        AfficherListeConsommable(consommations);
        System.out.println("SAISIR LE NUMERO DU CONSOMMABLE");
        String numero = sc.nextLine();
        for (Consommation cons: consommations
        ) {
            consommations.remove(cons);
        }
    }
}
