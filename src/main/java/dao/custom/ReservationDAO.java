package dao.custom;

import dao.CrudDAO;
import entity.Reservation;

import java.util.List;

public interface ReservationDAO extends CrudDAO<Reservation> {
    public List<Object[]> getResChart() throws Exception;

}
