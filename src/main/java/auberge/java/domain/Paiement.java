package auberge.java.domain;

import java.util.Date;

public class Paiement {
    private int idPaiement;
    private String numPaiement;
    private int montantPaye;
    private String descPaiement;
    private Date datePaiement;

    public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }


    public String getDescPaiement() {
        return descPaiement;
    }

    public void setDescPaiement(String descPaiement) {
        this.descPaiement = descPaiement;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public String getNumPaiement() {
        return numPaiement;
    }

    public void setNumPaiement(String numPaiement) {
        this.numPaiement = numPaiement;
    }

    public int getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(int montantPaye) {
        this.montantPaye = montantPaye;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }
}
