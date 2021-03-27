package auberge.java.repository;


import auberge.java.domain.Reservation;

public interface IReservationRepository {
    Reservation[] getAll();
    Reservation getById(int id);
    void add(Reservation reservation);
    void delete(Reservation reservation);
}
