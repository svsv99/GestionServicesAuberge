package auberge.java.domain;

public class Hotel {
    private int idHotel;
    private String nomHotel;
    private String typeHotel;
    private String descHotel;
    private String Adresse;

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public String getTypeHotel() {
        return typeHotel;
    }

    public void setTypeHotel(String typeHotel) {
        this.typeHotel = typeHotel;
    }

    public String getDescHotel() {
        return descHotel;
    }

    public void setDescHotel(String descHotel) {
        this.descHotel = descHotel;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }
}
