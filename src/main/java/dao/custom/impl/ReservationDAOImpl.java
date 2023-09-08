package dao.custom.impl;

import dao.custom.ReservationDAO;
import entity.Reservation;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import util.FactoryConfiguration;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {

    @Override
    public boolean add(Reservation reservation) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            session.persist(reservation);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public Reservation search(String idOrName) throws Exception {
        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            return session.get(Reservation.class, idOrName);

        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }

    }

    @Override
    public boolean update(Reservation reservation) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            session.update(reservation);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
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

            Reservation reservation = session.get(Reservation.class, id);
            session.delete(reservation);

            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();

        }

    }

    @Override
    public List<Reservation> getAll() throws Exception {
        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            NativeQuery query = session.createNativeQuery("SELECT  * FROM reservation");
            query.addEntity(Reservation.class);
            return query.list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();

        }

    }

    @Override
    public List<Object[]> getResChart() throws Exception {
        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            NativeQuery query = session.createNativeQuery("SELECT COUNT(date) , MONTH(date) as months FROM reservation GROUP BY MONTH(date) ORDER BY months ASC");
            return query.list();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();

        }

    }

}
