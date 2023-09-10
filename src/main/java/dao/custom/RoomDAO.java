package dao.custom;

import dao.CrudDAO;
import entity.Reservation;
import entity.Room;
import org.hibernate.Session;

public interface RoomDAO extends CrudDAO<Room> {
    public boolean update(Room room , Session session) throws Exception;

}
