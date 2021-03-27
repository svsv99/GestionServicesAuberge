package auberge.java.repository.jdbc;

import auberge.java.domain.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JdbcBasedReservationRepositoryTest {

    private JdbcBasedReservationRepository jdbcBasedReservationRepository;
    DateTimeFormatter df= DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @BeforeEach
    void SetUP() throws SQLException {
        System.out.println("Dans la Methode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcBasedReservationRepository = new JdbcBasedReservationRepository(dataSource);
        System.out.println("counted " + jdbcBasedReservationRepository.getAll().length);

    }

    @Test
    void getReservations(){
        System.out.println("Dans la methode getReservations");
        //Act
        Reservation[] reservations = jdbcBasedReservationRepository.getAll();
        //assert
        assertEquals(3,reservations.length,"Le nombre de reservation doit etre 3");

    }

    @Test
    void getReservationsWhenExceptionOccured(){
        System.out.println("Dans la methode getReservations lorsque on rencontre une exception");
        DataSource dataSource = mock(DataSource.class);
        when(dataSource.createConnection()).thenThrow(new RuntimeException("Base de données non disponible"));
        jdbcBasedReservationRepository = new JdbcBasedReservationRepository(dataSource);
        Reservation[] reservations = jdbcBasedReservationRepository.getAll();
        assertEquals(0,reservations.length,"le nombre de reservations doit être 0");
    }

    @Test
    void getByIdShouldReturnReservationWhenAvailable(){
        Reservation reservation = jdbcBasedReservationRepository.getById(1);
        assertNotNull(reservation);
        assertEquals(1, reservation.getIdReservation());
        assertEquals("Res004", reservation.getNumReservation());
    }

    @Test
    void getByIdShouldReturnReservationWhenAvailableNotTrivial() throws SQLException {
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

        Reservation reservation = jdbcBasedReservationRepository.getById(1);
        assertNotNull(reservation);
        assertEquals(1, reservation.getIdReservation());
        assertEquals("Res004", reservation.getNumReservation());
    }

    @Test
    public void addTest() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setIdReservation(100);
        reservation.setChambre("CH-001");
        reservation.setClient("Djoumoi");
        reservation.setDateArrivee(LocalDate.parse("2021-06-02",df));
        reservation.setDateReservation(LocalDate.parse("2021-06-02",df));
        reservation.setNumReservation("RES-001");
        jdbcBasedReservationRepository.add(reservation);
        Reservation retrievedReservation = jdbcBasedReservationRepository.getById(100);
        assertEquals(reservation.getNumReservation(), retrievedReservation.getNumReservation());
        jdbcBasedReservationRepository.delete(jdbcBasedReservationRepository.getById(100));

    }

    @Test
    public void deleteTest() throws Exception {
        Reservation reservation = new Reservation();
        reservation.setIdReservation(404);
        reservation.setChambre("CH-001");
        reservation.setClient("Djoumoi");
        reservation.setDateArrivee(LocalDate.parse("2021-06-02",df));
        reservation.setDateReservation(LocalDate.parse("2021-06-02",df));
        reservation.setNumReservation("RES-002");
        jdbcBasedReservationRepository.add(reservation);
        jdbcBasedReservationRepository.delete(reservation);
        assertEquals(null, jdbcBasedReservationRepository.getById(404));
    }
}