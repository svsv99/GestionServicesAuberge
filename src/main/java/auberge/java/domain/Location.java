package auberge.java.domain;

import java.time.LocalDate;
import java.util.Date;

public class Location {
    private int idLocation;
    private String numeroLocation;
    private LocalDate dateLocation;
    private LocalDate dateDepart;
    private static int cptLocation = 0;
    private  String chambre;
    private String client;
    /*private  Chambre chambre;
    private Client client;

     */
    public Location()
    {
        cptLocation++;
        idLocation = cptLocation;
    }

    //public Location(int id, String numeroLocation,Date dateLocation,) {
       // this.idLocation = id;
       // this.numeroLocation = numeroLocation;
    //}

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getNumeroLocation() {
        return numeroLocation;
    }

    public void setNumeroLocation(String numeroLocation) {
        this.numeroLocation = numeroLocation;
    }

    public LocalDate getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(LocalDate dateLocation) {
        this.dateLocation = dateLocation;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public static int getCptLocation() {
        return cptLocation;
    }

    public static void setCptLocation(int cptLocation) {
        Location.cptLocation = cptLocation;
    }

    public String getChambre() {
        return chambre;
    }

    public void setChambre(String chambre) {
        this.chambre = chambre;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Location(int idLocation, String numeroLocation, LocalDate dateLocation, LocalDate dateDepart, String chambre, String client)
    {
        this.idLocation = idLocation;
        this.numeroLocation = numeroLocation;
        this.dateLocation = dateLocation;
        this.dateDepart = dateDepart;
        this.chambre = chambre;
        this.client = client;
    }
}
