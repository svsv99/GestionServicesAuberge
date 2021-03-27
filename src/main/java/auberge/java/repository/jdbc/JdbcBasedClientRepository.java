package auberge.java.repository.jdbc;

import auberge.java.domain.Client;
import auberge.java.repository.IClientRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcBasedClientRepository implements IClientRepository {
    private final DataSource dataSource;
    public JdbcBasedClientRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public Client[] getAll() {
            //requête sql pour récupèrer les infos
            String query = "SELECT * FROM client";
            //mapper le résultat
            List<Client> clients = new ArrayList<Client>();

            try {
                Connection connection = dataSource.createConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);

                while (rs.next()) {
                    int idClient = rs.getInt("idClient");
                    String matriculeClient = rs.getString("matriculeClient");
                    String nomClient = rs.getString("nomClient");
                    String prenomClient = rs.getString("prenomClient");
                    String adresseClient = rs.getString("adresseClient");
                    String emailClient= rs.getString("emailClient");
                    String telClient= rs.getString("telClient");
                    String username= rs.getString("username");
                    String password= rs.getString("password");

                    //mapping retour db (relationnel) avec objet Prestation
                    Client client = new Client(idClient,matriculeClient, nomClient, prenomClient,adresseClient,emailClient,telClient,username,password);

                    clients.add(client);
                }
                return clients.toArray(new Client[0]);

            } catch (SQLException e) {
                return new Client[0];
            } catch (Exception ex) {
                return new Client[0];
            }
    }

    @Override
    public Client getById(int id) {
        String query = "SELECT * from client where idClient = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                int retrievedidClient = rs.getInt("idClient");
                String retrievedmatriculeClient = rs.getString("matriculeClient");
                String retrievednomClient = rs.getString("nomClient");
                String retrievedprenomClient = rs.getString("prenomClient");
                String retrievedadresseClient = rs.getString("adresseClient");
                String retrievedemailClient= rs.getString("emailClient");
                String retrievedtelClient= rs.getString("telClient");
                String retrievedusername= rs.getString("username");
                String retrievedpassword= rs.getString("password");

                Client client = new Client(retrievedidClient, retrievedmatriculeClient,retrievednomClient,retrievedprenomClient
                        ,retrievedadresseClient,retrievedemailClient,retrievedtelClient,retrievedusername,retrievedpassword);
                return client;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public void add(Client client) {
        String query =  "INSERT INTO client(idClient,matriculeClient, nomClient, prenomClient, adresseClient" +
                ",telClient, emailClient, username, password) VALUES ("+ client.getIdclient() +",'"+ client.getMatriculeClient() + "','" +
                client.getNomClient() + "', '" + client.getPrenomClient()+"', '"+client.getAdresseClient()+ "' , '" +
                client.getTelClient() + "', '" +client.getEmailClient() + "', '" +client.getUsername() + "', '" + client.getPassword()+"' )";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Client client) {
        String query = "DELETE from client where idClient = " + client.getIdclient();


        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
