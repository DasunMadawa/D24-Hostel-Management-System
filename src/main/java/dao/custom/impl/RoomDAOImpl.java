package dao.custom.impl;

import dao.custom.RoomDAO;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean add(Room room) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(room);
        transaction.commit();
        session.close();
        return false;

    }

    @Override
    public Room search(String idOrName) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Room room = session.get(Room.class, idOrName);
        session.close();
        return room;

    }

    @Override
    public boolean update(Room room) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(room);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.get(Room.class, id);
        session.delete(room);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public List<Room> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        NativeQuery query = session.createNativeQuery("SELECT * FROM room");
        query.addEntity(Room.class);
        List<Room> list = query.list();
        session.close();
        return list;

    }

}
