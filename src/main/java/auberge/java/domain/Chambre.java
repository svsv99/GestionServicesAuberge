package auberge.java.domain;

import java.util.Scanner;

public class Chambre {
    private int idChambre;
    private String numChambre;
    private String typeChambre;
    private String descriptionChambre;
    private int prixChambre;
    private String statutChambre;
    private static int cptChambre = 0;
    public Chambre()
    {
        cptChambre++;
        idChambre = cptChambre;
    }


    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public String getNumChambre() {
        return numChambre;
    }

    public void setNumChambre(String numChambre) {
        this.numChambre = numChambre;
    }

    public String getTypeChambre() {
        return typeChambre;
    }

    public void setTypeChambre(String typeChambre) {
        this.typeChambre = typeChambre;
    }

    public String getDescriptionChambre() {
        return descriptionChambre;
    }

    public void setDescriptionChambre(String descriptionChambre) {
        this.descriptionChambre = descriptionChambre;
    }

    public int getPrixChambre() {
        return prixChambre;
    }

    public void setPrixChambre(int prixChambre) {
        this.prixChambre = prixChambre;
    }

    public static int getCptChambre() {
        return cptChambre;
    }

    public static void setCptChambre(int cptChambre) {
        Chambre.cptChambre = cptChambre;
    }

    public String getStatutChambre() {
        return statutChambre;
    }

    public void setStatutChambre(String statutChambre) {
        this.statutChambre = statutChambre;
    }


    public Chambre(int idChambre,String numChambre,String typeChambre, int prixChambre, String descriptionChambre,String statutChambre)
    {
        this.idChambre = idChambre;
        this.numChambre = numChambre;
        this.prixChambre = prixChambre;
        this.descriptionChambre = descriptionChambre;
        this.statutChambre = statutChambre;
        this.typeChambre = typeChambre;
    }
}
