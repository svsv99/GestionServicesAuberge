package auberge.java.repository.jdbc;

import auberge.java.domain.Chambre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JdbcBasedChambreRepositoryTest {
    private JdbcBasedChambreRepository jdbcBasedChambreRepository;

    @BeforeEach
    void SetUP() throws SQLException {
        System.out.println("Dans la Methode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcBasedChambreRepository = new JdbcBasedChambreRepository(dataSource);
        System.out.println("counted " + jdbcBasedChambreRepository.getAll().length);

    }

    @Test
    void getReservations(){
        System.out.println("Dans la methode getChambres");
        //Act
        Chambre[] chambres = jdbcBasedChambreRepository.getAll();
        //assert
        assertEquals(3,chambres.length,"Le nombre de Chambres doit etre egale à  3");

    }

    @Test
    void getChambresWhenExceptionOccured(){
        System.out.println("Dans la methode getChambres lorsque on rencontre une exception");
        DataSource dataSource = mock(DataSource.class);
        when(dataSource.createConnection()).thenThrow(new RuntimeException("Base de données non disponible"));
        jdbcBasedChambreRepository = new JdbcBasedChambreRepository(dataSource);
        Chambre[] chambres = jdbcBasedChambreRepository.getAll();
        assertEquals(0,chambres.length,"le nombre de Chambres doit être 0");
    }

    @Test
    void getByIdShouldReturnChambresWhenAvailable(){
        Chambre chambre = jdbcBasedChambreRepository.getById(1);
        assertNotNull(chambre);
        assertEquals(1, chambre.getIdChambre());
        assertEquals("CH004", chambre.getNumChambre());
    }

    @Test
    void getByIdShouldReturnChambresWhenAvailableNotTrivial() throws SQLException {
       /* DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);

        when(dataSource.createConnection()).thenReturn(connection);
        Statement statement = mock(Statement.class);
        when(connection.createStatement()).thenReturn(statement);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        ResultSet resultSet2 = mock(ResultSet.class);
        when(preparedStatement.executeQuery()).thenReturn(resultSet2);
        when(resultSet2.getInt(anyString())).thenReturn(1);
        when(resultSet2.getString(anyString())).thenReturn("aaaa");

        jdbcBasedReservationRepository = new JdbcBasedReservationRepository(dataSource);*/

        Chambre chambre = jdbcBasedChambreRepository.getById(1);
        assertNotNull(chambre);
        assertEquals(1, chambre.getIdChambre());
        assertEquals("CH004", chambre.getNumChambre());
    }

    @Test
    public void addTest() throws Exception {
        Chambre chambre = new Chambre();
        chambre.setIdChambre(100);
        chambre.setNumChambre("CH-100");
        chambre.setPrixChambre(200000);
        chambre.setStatutChambre("NO");
        chambre.setTypeChambre("Partagé");
        chambre.setDescriptionChambre("confort");
        jdbcBasedChambreRepository.add(chambre);
        Chambre retrievedChambre = jdbcBasedChambreRepository.getById(100);
        assertEquals(chambre.getNumChambre(), retrievedChambre.getNumChambre());
        jdbcBasedChambreRepository.delete(jdbcBasedChambreRepository.getById(100));
    }

    @Test
    public void deleteTest() throws Exception {
        Chambre chambre = new Chambre();
        chambre.setIdChambre(404);
        chambre.setNumChambre("CH-404");
        chambre.setPrixChambre(200000);
        chambre.setStatutChambre("NO");
        chambre.setTypeChambre("Partagé");
        chambre.setDescriptionChambre("confort");
        jdbcBasedChambreRepository.add(chambre);
        jdbcBasedChambreRepository.delete(chambre);
        assertEquals(null, jdbcBasedChambreRepository.getById(404));
    }
}