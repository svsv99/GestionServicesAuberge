package auberge.java.repository;

import auberge.java.domain.Chambre;

import java.util.List;
import java.util.Scanner;

public class ChambreRepository {

    public Chambre AjouterChambre(List<Chambre> chambres)
    {
        Chambre c = new Chambre();
        Scanner sc = new Scanner(System.in);
        c.setNumChambre("CH-"+"00" +c.getIdChambre());
        System.out.println("SAISIR LE TYPE DE CHAMBRE");
        c.setTypeChambre(sc.nextLine());
        System.out.println("SAISIR UNE DESCRIPTION DE LA CHAMBRE");
        c.setDescriptionChambre(sc.nextLine());
        System.out.println("SAISIR LE STATUT DE LA CHAMBRE");
        c.setStatutChambre(sc.nextLine());
        System.out.println("SAISIR LE PRIX DE LA CHAMBRE");
        c.setPrixChambre(sc.nextInt());
        chambres.add(c);
        return c;
    }

    public void AfficherListeChambre(List<Chambre> chambres)
    {
        for (Chambre c: chambres) {
            System.out.println("--------------------------------------------");
            System.out.println("NUM CHAMBRE: " + c.getNumChambre());
            System.out.println("DESC CHAMBRE: " + c.getDescriptionChambre());
            System.out.println("DESC CHAMBRE: " + c.getStatutChambre());
            System.out.println("TYPE CHAMBRE: " + c.getTypeChambre());
            System.out.println("PRIX CHAMBRE: " + c.getPrixChambre());
            System.out.println("--------------------------------------------");
        }
    }


    public void ModifierChambre(List<Chambre> chambres)
    {
        Scanner sc = new Scanner(System.in);
        AfficherListeChambre(chambres);
        System.out.println("SAISIR le numero DE LA CHAMBRE");
        String numero = sc.nextLine();
        for (Chambre c: chambres
             ) {
            if(c.getNumChambre().toLowerCase().equals(numero.toLowerCase()))
            {
                c.setNumChambre("CH-"+"00" +c.getIdChambre());
                System.out.println("SAISIR LE TYPE DE CHAMBRE");
                c.setTypeChambre(sc.nextLine());
                System.out.println("SAISIR UNE DESCRIPTION DE LA CHAMBRE");
                c.setDescriptionChambre(sc.nextLine());
                System.out.println("SAISIR LE STATUT DE LA CHAMBRE");
                c.setStatutChambre(sc.nextLine());
                System.out.println("SAISIR LE PRIX DE LA CHAMBRE");
                c.setPrixChambre(sc.nextInt());
            }
        }
    }


    public void SupprimerChambre(List<Chambre> chambres){
        Scanner sc = new Scanner(System.in);
        AfficherListeChambre(chambres);
        System.out.println("SAISIR le numero DE LA CHAMBRE");
        String numero = sc.nextLine();
        for (Chambre c: chambres
        ) {
            if(c.getNumChambre().toLowerCase().equals(numero.toLowerCase())) {
                chambres.remove(c);
            }
        }
    }
    public Chambre ChoisirChambre(List<Chambre> chambres){
        Scanner sc = new Scanner(System.in);
        AfficherListeChambre(chambres);
        System.out.println("SAISIR le numero DE LA CHAMBRE CHOISIE");
        String numero = sc.nextLine();
        for (Chambre c: chambres
        ) {
            if(c.getNumChambre().toLowerCase().equals(numero.toLowerCase())) {
                return c;
            }
        }
        return null;
    }
}
