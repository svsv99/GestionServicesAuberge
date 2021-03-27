package auberge.java.repository;

import auberge.java.domain.Chambre;

public interface IChambreRepository {
    Chambre[] getAll();
    Chambre getById(int id);
    void add(Chambre chambre);
    void delete(Chambre chambre);
}
