package auberge.java.domain;

public class Consommation {
    private int idConsommation;
    private String numConsommation;
    private String libelleConsommation;
    private int puConsommation;
    private String statutConsommation;
    private static int cptConsommation = 0;

    public Consommation() {
        cptConsommation++;
        idConsommation = cptConsommation;
    }

    public int getIdConsommation() {
        return idConsommation;
    }

    public void setIdConsommation(int idConsommation) {
        this.idConsommation = idConsommation;
    }

    public String getNumConsommation() {
        return numConsommation;
    }

    public void setNumConsommation(String numConsommation) {
        this.numConsommation = numConsommation;
    }

    public String getLibelleConsommation() {
        return libelleConsommation;
    }

    public void setLibelleConsommation(String libelleConsommation) {
        this.libelleConsommation = libelleConsommation;
    }

    public int getPuConsommation() {
        return puConsommation;
    }

    public void setPuConsommation(int puConsommation) {
        this.puConsommation = puConsommation;
    }

    public String getStatutConsommation() {
        return statutConsommation;
    }

    public void setStatutConsommation(String statutConsommation) {
        this.statutConsommation = statutConsommation;
    }

    public static int getCptConsommation() {
        return cptConsommation;
    }

    public static void setCptConsommation(int cptConsommation) {
        Consommation.cptConsommation = cptConsommation;
    }

    public Consommation(String numConsommation, String libelleConsommation, int puConsommation, String statutConsommation){
        this.numConsommation = numConsommation;
        this.libelleConsommation = libelleConsommation;
        this.puConsommation = puConsommation;
        this.statutConsommation = statutConsommation;

    }
}
