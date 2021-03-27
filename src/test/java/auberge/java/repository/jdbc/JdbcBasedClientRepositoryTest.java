package auberge.java.repository.jdbc;

import auberge.java.domain.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class JdbcBasedClientRepositoryTest {
    private JdbcBasedClientRepository jdbcBasedClientRepository;
    @BeforeEach
    void SetUP() throws SQLException {
        System.out.println("Dans la Methode setup");
        //Arrange
        DataSource dataSource = new MysqlDataSource();
        jdbcBasedClientRepository = new JdbcBasedClientRepository(dataSource);
        System.out.println("counted " + jdbcBasedClientRepository.getAll().length);

    }

    @Test
    void getClients(){
        System.out.println("Dans la methode getClients");
        //Act
        Client[] clients = jdbcBasedClientRepository.getAll();
        //assert
        assertEquals(1,clients.length,"Le nombre de client doit etre 1");

    }

    @Test
    void getClientsWhenExceptionOccured(){
        System.out.println("Dans la methode Clients lorsque on rencontre une exception");
        DataSource dataSource = mock(DataSource.class);
        when(dataSource.createConnection()).thenThrow(new RuntimeException("Base de données non disponible"));
        jdbcBasedClientRepository = new JdbcBasedClientRepository(dataSource);
        Client[] clients = jdbcBasedClientRepository.getAll();
        assertEquals(0,clients.length,"le nombre de client doit être 0");
    }

    @Test
    void getByIdShouldReturnClientsWhenAvailable(){
        Client client = jdbcBasedClientRepository.getById(1);
        assertNotNull(client);
        assertEquals(1, client.getIdclient());
        assertEquals("Salma", client.getNomClient());
    }

    @Test
    void getByIdShouldReturnClientsWhenAvailableNotTrivial() throws SQLException {
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

        Client client = jdbcBasedClientRepository.getById(1);
        assertNotNull(client);
        assertEquals(1, client.getIdclient());
        assertEquals("Salma", client.getNomClient());
    }
    @Test
    public void addTest() throws Exception {
        Client client = new Client();
        client.setIdclient(100);
        client.setNomClient("Salma");
        client.setPrenomClient("Djoumoi");
        client.setAdresseClient("Dakar");
        client.setEmailClient("djoumoi@gmail.com");
        client.setUsername("admin");
        client.setPassword("passer");
        client.setTelClient("770126655");
        client.setMatriculeClient("CLI-001");
        jdbcBasedClientRepository.add(client);
        Client retrievedClient = jdbcBasedClientRepository.getById(100);
        assertEquals(client.getMatriculeClient(), retrievedClient.getMatriculeClient());
        jdbcBasedClientRepository.delete(jdbcBasedClientRepository.getById(100));
    }

    @Test
    public void deleteTest() throws Exception {
        Client client = new Client();
        client.setIdclient(404);
        client.setNomClient("Salma");
        client.setPrenomClient("Djoumoi");
        client.setAdresseClient("Dakar");
        client.setEmailClient("djoumoi@gmail.com");
        client.setUsername("admin");
        client.setPassword("passer");
        client.setTelClient("770126655");
        client.setMatriculeClient("CLI-001");
        jdbcBasedClientRepository.add(client);
        jdbcBasedClientRepository.delete(client);
        assertEquals(null, jdbcBasedClientRepository.getById(404));
    }
}