package auberge.java.repository.jdbc;

import auberge.java.domain.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JdbcBasedLocationRepositoryTest {
    private JdbcBasedLocationRepository jdbcBasedLocationRepository;
    DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @BeforeEach
    void SetUP() throws SQLException {
        System.out.println("Dans la Methode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcBasedLocationRepository = new JdbcBasedLocationRepository(dataSource);
        System.out.println("counted " + jdbcBasedLocationRepository.getAll().length);

    }

    @Test
    void getLocations(){
        System.out.println("Dans la methode getLocations");
        //Act
        Location[] locations = jdbcBasedLocationRepository.getAll();
        //assert
        assertEquals(1,locations.length,"Le nombre de location doit etre 1");

    }

    @Test
    void getLocationsWhenExceptionOccured(){
        System.out.println("Dans la methode getLocations lorsque on rencontre une exception");
        DataSource dataSource = mock(DataSource.class);
        when(dataSource.createConnection()).thenThrow(new RuntimeException("Base de données non disponible"));
        jdbcBasedLocationRepository = new JdbcBasedLocationRepository(dataSource);
        Location[] locations = jdbcBasedLocationRepository.getAll();
        assertEquals(0,locations.length,"le nombre de locations doit être 0");
    }

    @Test
    void getByIdShouldReturnLocationsWhenAvailable(){
        Location location = jdbcBasedLocationRepository.getById(1);
        assertNotNull(location);
        assertEquals(1, location.getIdLocation());
        assertEquals("LO001", location.getNumeroLocation());
    }

    @Test
    void getByIdShouldReturnLocationsWhenAvailableNotTrivial() throws SQLException {
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

        Location location = jdbcBasedLocationRepository.getById(1);
        assertNotNull(location);
        assertEquals(1, location.getIdLocation());
        assertEquals("LO001", location.getNumeroLocation());
    }

    @Test
    public void addTest() throws Exception {
        Location location = new Location();
        location.setIdLocation(100);
        location.setChambre("CH-001");
        location.setClient("Djoumoi");
        location.setDateDepart(LocalDate.parse("2021-08-02",df));
        location.setDateLocation(LocalDate.parse("2021-06-02",df));
        location.setNumeroLocation("LOC-001");
        jdbcBasedLocationRepository.add(location);
        Location retrievedLocation = jdbcBasedLocationRepository.getById(100);
        assertEquals(location.getNumeroLocation(), retrievedLocation.getNumeroLocation());
        jdbcBasedLocationRepository.delete(jdbcBasedLocationRepository.getById(100));
    }

    @Test
    public void deleteTest() throws Exception {
        Location location = new Location();
        location.setIdLocation(404);
        location.setChambre("CH-001");
        location.setClient("Djoumoi");
        location.setDateDepart(LocalDate.parse("2021-08-02",df));
        location.setDateLocation(LocalDate.parse("2021-06-02",df));
        location.setNumeroLocation("LOC-001");
        jdbcBasedLocationRepository.add(location);
        jdbcBasedLocationRepository.delete(location);
        assertEquals(null, jdbcBasedLocationRepository.getById(404));
    }
}