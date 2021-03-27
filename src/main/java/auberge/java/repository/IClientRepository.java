package auberge.java.repository;


import auberge.java.domain.Client;

public interface IClientRepository {
    Client[] getAll();
    Client getById(int id);
    void add(Client client);
    void delete(Client client);
}
