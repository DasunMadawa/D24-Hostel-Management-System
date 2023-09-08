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
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            session.persist(room);
            transaction.commit();
            return false;
        }catch (Exception e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();

        }

    }

    @Override
    public Room search(String idOrName) throws Exception {
        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            Room room = session.get(Room.class, idOrName);
            return room;
        }catch (Exception e) {
            throw e;
        }finally {
            session.close();

        }

    }

    @Override
    public boolean update(Room room) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            session.update(room);
            transaction.commit();

            return true;
        }catch (Exception e) {
            transaction.rollback();
            throw e;
        }finally {
            session.close();

        }

    }

    @Override
    public boolean delete(String id) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            Room room = session.get(Room.class, id);
            session.delete(room);
            transaction.commit();
            return true;
        }catch (Exception e) {
            transaction.rollback();
            throw e;
        }finally {
            session.close();

        }

    }

    @Override
    public List<Room> getAll() throws Exception {
        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            NativeQuery query = session.createNativeQuery("SELECT * FROM room");
            query.addEntity(Room.class);
            return query.list();
        }catch (Exception e) {
            throw e;
        }finally {
            session.close();

        }

    }

}
