package dao.custom;

import dao.CrudDAO;
import entity.Reservation;
import entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface ReservationDAO extends CrudDAO<Reservation> {
    public List<Object[]> getResChart() throws Exception;
    public boolean add(Reservation reservation , Session session) throws Exception;

}
