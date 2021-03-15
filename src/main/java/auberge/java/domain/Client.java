package auberge.java.domain;

public class Client {
    private int idclient;
    private String matriculeClient;
    private String nomClient;
    private String prenomClient;
    private String adresseClient;
    private String telClient;
    private String emailClient;
    private String username;
    private String password;
    private static int cptClient = 0;
    public Client()
    {
        cptClient++;
        idclient = cptClient;
    }
    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getMatriculeClient() {
        return matriculeClient;
    }

    public void setMatriculeClient(String matriculeClient) {
        this.matriculeClient = matriculeClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getAdresseClient() {
        return adresseClient;
    }

    public void setAdresseClient(String adresseClient) {
        this.adresseClient = adresseClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Client(int idclient,String matriculeClient, String nomClient,String prenomClient,
                  String adresseClient,String emailClient,String telClient,String username,String password)
    {
        this.idclient = idclient;
        this.matriculeClient = matriculeClient;
        this.emailClient = emailClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.adresseClient = adresseClient;
        this.username = username;
        this.password = password;
    }
}
