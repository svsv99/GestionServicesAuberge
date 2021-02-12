package auberge.java.domain;

import java.time.LocalDate;
import java.util.Date;

public class Location {
    private int idLocation;
    private String numeroLocation;
    private Date dateLocation;
    private LocalDate dateDepart;
    private static int cptLocation = 0;
    private  Chambre chambre;
    private Client client;
    public Location()
    {
        cptLocation++;
        idLocation = cptLocation;
    }
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

    public Date getDateLocation() {
        return dateLocation;
    }

    public void setDateLocation(Date dateLocation) {
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

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Location(String numeroLocation, Date dateLocation, LocalDate dateDepart,  Chambre chambre,Client client)
    {
        this.numeroLocation = numeroLocation;
        this.dateLocation = dateLocation;
        this.dateDepart = dateDepart;
        this.chambre = chambre;
        this.client = client;
    }
}
