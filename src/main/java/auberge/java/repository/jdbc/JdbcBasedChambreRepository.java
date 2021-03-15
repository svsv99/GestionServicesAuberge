package auberge.java.repository.jdbc;

import auberge.java.domain.Chambre;
import auberge.java.repository.IChambreRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JdbcBasedChambreRepository implements IChambreRepository {
    private final DataSource dataSource;
    public JdbcBasedChambreRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Chambre[] getAll() {
        //requête sql pour récupèrer les infos
        String query = "SELECT * FROM chambre";
        //mapper le résultat
        List<Chambre> chambres = new ArrayList<Chambre>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                int idChambre = rs.getInt("idChambre");
                String  numChambre = rs.getString("numChambre");
                String  descriptionChambre = rs.getString("descriptionChambre");
                String statutChambre = rs.getString("statutChambre");
                String typeChambre = rs.getString("typeChambre");
                int prixChambre   = rs.getInt("prixChambre");

                //mapping retour db (relationnel) avec objet Prestation
                Chambre chambre = new Chambre(idChambre, numChambre, typeChambre,prixChambre,descriptionChambre,statutChambre);

                chambres.add(chambre);
            }
            return chambres.toArray(new Chambre[0]);

        } catch (SQLException e) {
            return new Chambre[0];
        } catch (Exception ex) {
            return new Chambre[0];
        }

    }

    @Override
    public Chambre getById(int id) {
        String query = "SELECT * from chambre where id = ?";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            int retrievedidChambre = rs.getInt("idChambre");
            String  retrievednumChambre = rs.getString("numChambre");
            String  retrieveddescriptionChambre = rs.getString("descriptionChambre");
            String retrievedstatutChambre = rs.getString("statutChambre");
            String retrievedtypeChambre = rs.getString("typeChambre");
            int retrievedprixChambre   = rs.getInt("prixChambre");

            Chambre chambre = new Chambre(retrievedidChambre, retrievednumChambre,retrievedtypeChambre,retrievedprixChambre,retrieveddescriptionChambre,retrievedstatutChambre);
            return chambre;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }
}
