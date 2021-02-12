package auberge.java.domain;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private int idReservation;
    private String numReservation;
    private Date dateReservation;
    private LocalDate dateArrivee;
    private LocalDate dateDepart;
    private Date datePayeArrhes;
    private int montantArrhes;
    private boolean annuler;
    private static int cptRservation = 0;
    private  Chambre chambre;
    private Client client;
    public Reservation()
    {
        cptRservation++;
        idReservation = cptRservation;
        montantArrhes = 40000;
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

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public String getNumReservation() {
        return numReservation;
    }

    public void setNumReservation(String numReservation) {
        this.numReservation = numReservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public LocalDate getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(LocalDate dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDatePayeArrhes() {
        return datePayeArrhes;
    }

    public void setDatePayeArrhes(Date datePayeArrhes) {
        this.datePayeArrhes = datePayeArrhes;
    }

    public int getMontantArrhes() {
        return montantArrhes;
    }

    public void setMontantArrhes(int montantArrhes) {
        this.montantArrhes = montantArrhes;
    }

    public boolean isAnnuler() {
        return annuler;
    }

    public void setAnnuler(boolean annuler) {
        this.annuler = annuler;
    }

    public static int getCptRservation() {
        return cptRservation;
    }

    public static void setCptRservation(int cptRservation) {
        Reservation.cptRservation = cptRservation;
    }


    public Reservation(String numReservation, Date dateReservation, LocalDate dateArrivee,
            LocalDate dateDepart, Date datePayeArrhes, int montantArrhes, boolean annuler, Chambre chambre,
            Client client)
    {
        this.numReservation = numReservation;
        this.dateReservation = dateReservation;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.datePayeArrhes = datePayeArrhes;
        this.montantArrhes = montantArrhes;
        this.annuler = annuler;
        this.chambre = chambre;
        this.client = client;
    }
}
