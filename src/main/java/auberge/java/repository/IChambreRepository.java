package auberge.java.repository;

import auberge.java.domain.Chambre;

public interface IChambreRepository {
    Chambre[] getAll();
    Chambre getById(int id);
}
