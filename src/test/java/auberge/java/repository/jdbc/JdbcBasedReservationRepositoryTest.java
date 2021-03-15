package auberge.java.repository.jdbc;

import auberge.java.domain.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JdbcBasedReservationRepositoryTest {

    private JdbcBasedReservationRepository jdbcBasedReservationRepository;

    @BeforeEach
    void SetUP() throws SQLException {
        System.out.println("Dans la Methode setup");
        //Arrange
        DataSource dataSource = new MockDatasource();
        jdbcBasedReservationRepository = new JdbcBasedReservationRepository(dataSource);

    }

    @Test
    void getReservations(){
        System.out.println("Dans la methode getReservations");
        //Act
        Reservation[] reservations = jdbcBasedReservationRepository.getAll();
        //assert
        assertEquals(2,reservations.length,"Le nombre de reservation doit etre 2");

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
    void getByIdShouldReturnProfilWhenAvailable(){
        Reservation reservation = jdbcBasedReservationRepository.getById(1);
        assertNotNull(reservation);
        assertEquals(1, reservation.getIdReservation());
        assertEquals("", reservation.getNumReservation());
    }

    @Test
    void getByIdShouldReturnPrestationWhenAvailableNotTrivial() throws SQLException {
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);

        when(dataSource.createConnection()).thenReturn(connection);
        Statement statement = mock(Statement.class);
        when(connection.createStatement()).thenReturn(statement);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        ResultSet resultSet2 = mock(ResultSet.class);
        when(preparedStatement.executeQuery()).thenReturn(resultSet2);
        when(resultSet2.getInt(anyString())).thenReturn(5);
        when(resultSet2.getString(anyString())).thenReturn("aaaa");

        jdbcBasedReservationRepository = new JdbcBasedReservationRepository(dataSource);

        Reservation reservation = jdbcBasedReservationRepository.getById(5);
        assertNotNull(reservation);
        assertEquals(5, reservation.getIdReservation());
        assertEquals("aaaa", reservation.getNumReservation());
    }
}