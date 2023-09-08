package dao.custom.impl;

import dao.custom.UserDAO;
import entity.Reservation;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean add(User user) throws Exception{
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            session.persist(user);
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
    public User search(String idOrName) throws Exception{
        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            User user = session.get(User.class, idOrName);
            return user;
        }catch (Exception e) {
            throw e;
        }finally {
            session.close();

        }

    }

    @Override
    public boolean update(User user) throws Exception{
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            session.update(user);
            transaction.commit();
            return true;
        }catch (Exception e) {
            throw e;
        }finally {
            session.close();

        }

    }

    @Override
    public boolean delete(String id) throws Exception{
        return false;

    }

    @Override
    public List<User> getAll() throws Exception{
        return null;

    }

}
