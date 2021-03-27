package auberge.java.repository.jdbc;

import auberge.java.domain.Reservation;
import auberge.java.repository.IReservationRepository;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JdbcBasedReservationRepository implements IReservationRepository {
    DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final DataSource dataSource;
    public JdbcBasedReservationRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Reservation[] getAll() {
//requête sql pour récupèrer les infos
        String query = "SELECT idReservation, numReservation, dateReservation, dateArrivee, Chambre, Client FROM reservation";
        //mapper le résultat
        List<Reservation> reservations = new ArrayList<Reservation>();

        try {
            Connection connection = dataSource.createConnection();
            System.out.println("connection: " + connection);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                int idReservation = rs.getInt("idReservation");
                String numReservation = rs.getString("numReservation");
                LocalDate dateReservation = LocalDate.parse(rs.getString("dateReservation"),df);
                LocalDate dateArrivee   = LocalDate.parse(rs.getString("dateArrivee"),df);
                String chambre = rs.getString("chambre");
                String client = rs.getString("client");
                //mapping retour db (relationnel) avec objet Prestation
                Reservation reservation = new Reservation(idReservation, numReservation, dateReservation,dateArrivee,chambre,client);
                reservations.add(reservation);
            }
            System.out.println("counted 1 :  "  + reservations.size());

            return reservations.toArray(new Reservation[0]);

        } catch (SQLException e) {
            return new Reservation[0];
        } catch (Exception ex) {
            return new Reservation[0];
        }
    }
    @Override
    public Reservation getById(int id) {
        String query = "SELECT * FROM reservation where idReservation = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                int retrievedidReservation = rs.getInt("idReservation");
                String retrievednumReservation = rs.getString("numReservation");
               // System.out.println("rs.getString(\"dateReservation\") = " + rs.getString("numReservation"));
                LocalDate retrieveddateReservation = LocalDate.parse(rs.getString("dateReservation"),df);
                LocalDate retrieveddateArrivee   = LocalDate.parse(rs.getString("dateArrivee"),df);
                String retrievedchambre = rs.getString("chambre");
                String retrievedclient = rs.getString("client");

                Reservation reservation = new Reservation(retrievedidReservation, retrievednumReservation,retrieveddateReservation,retrieveddateArrivee,retrievedchambre,retrievedclient);
                return reservation;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public void add(Reservation reservation) {
        String query =  "INSERT INTO reservation(idReservation,numReservation, dateReservation, dateArrivee, chambre" +
                ",client) VALUES ("+ reservation.getIdReservation() +",'"+ reservation.getNumReservation() + "','" +
                reservation.getDateReservation() + "', '" + reservation.getDateArrivee()+"', '"+reservation.getChambre()+ "','" +
                reservation.getClient()+"' )";

        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Reservation reservation) {
        String query = "DELETE from reservation where idReservation = " + reservation.getIdReservation();


        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

