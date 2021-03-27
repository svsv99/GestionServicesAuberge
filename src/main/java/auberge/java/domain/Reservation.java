package auberge.java.domain;

import java.time.LocalDate;

public class Reservation {
    private int idReservation;
    private String numReservation;
    private LocalDate dateReservation;
    private LocalDate dateArrivee;
    private LocalDate dateDepart;
    private LocalDate datePayeArrhes;
    private int montantArrhes;
    private boolean annuler;
    private static int cptRservation = 0;
    private  String chambre;
    private String client;
    /*private  Chambre chambre;
    private Client client;

     */
    public Reservation()
    {
        cptRservation++;
        idReservation = cptRservation;
        montantArrhes = 40000;
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

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
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

    public LocalDate getDatePayeArrhes() {
        return datePayeArrhes;
    }

    public void setDatePayeArrhes(LocalDate datePayeArrhes) {
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

    public Reservation(int idReservation, String numReservation, LocalDate dateReservation, LocalDate dateArrivee, String chambre, String client)
    {
        this.idReservation = idReservation;
        this.numReservation = numReservation;
        this.dateReservation = dateReservation;
        this.dateArrivee = dateArrivee;
        this.chambre = chambre;
        this.client = client;
    }
}
