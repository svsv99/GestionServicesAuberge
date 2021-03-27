package auberge.java.repository.jdbc;

import auberge.java.domain.Location;
import auberge.java.repository.ILocationRepository;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JdbcBasedLocationRepository implements ILocationRepository {
    DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final DataSource dataSource;
    public JdbcBasedLocationRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public Location[] getAll() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM location";
        //mapper le résultat
        List<Location> locations = new ArrayList<Location>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                int idLocation = rs.getInt("idLocation");
                String numeroLocation = rs.getString("numeroLocation");
                LocalDate dateLocation = LocalDate.parse(rs.getString("dateLocation"),df);
                LocalDate dateDepart   = LocalDate.parse(rs.getString("dateDepart"),df);
                String chambre = rs.getString("chambre");
                String client = rs.getString("client");

                //mapping retour db (relationnel) avec objet Prestation
                Location location = new Location(idLocation, numeroLocation, dateLocation,dateDepart,chambre,client);

                locations.add(location);
            }
            return locations.toArray(new Location[0]);

        } catch (SQLException e) {
            return new Location[0];
        } catch (Exception ex) {
            return new Location[0];
        }

    }

    @Override
    public Location getById(int id) {
        String query = "SELECT * from location where idLocation = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id );
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                int retrievedId = rs.getInt("idLocation");
                String retrievednumeroLocation = rs.getString("numeroLocation");

                LocalDate retrieveddateLocation = LocalDate.parse(rs.getString("dateLocation"),df);
                LocalDate retrieveddateDepart   = LocalDate.parse(rs.getString("dateDepart"),df);
                String retrievedchambre = rs.getString("chambre");
                String retrievedclient = rs.getString("client");

                Location location = new Location(retrievedId, retrievednumeroLocation,retrieveddateLocation,retrieveddateDepart,retrievedchambre,retrievedclient);
                return location;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public void add(Location location) {
        String query =  "INSERT INTO location(idLocation,numeroLocation, dateLocation, dateDepart, chambre" +
                ",client) VALUES ("+ location.getIdLocation() +",'"+ location.getNumeroLocation() + "','" +
                location.getDateDepart() + "', '" + location.getDateDepart()+"', '"+location.getChambre()+ "','" +
                location.getClient()+"' )";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Location location) {
        String query = "DELETE from location where idLocation = " + location.getIdLocation();


        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
