package auberge.java.repository.jdbc;


import auberge.java.domain.Client;

public interface IClientRepository {
    Client[] getAll();
    Client getById(int id);
}
