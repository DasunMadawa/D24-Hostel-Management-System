package dao.custom.impl;

import dao.CrudDAO;
import dao.custom.StudentDAO;
import entity.Room;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws Exception{
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            session.persist(student);
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
    public Student search(String idOrName) throws Exception{
        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            NativeQuery query = session.createNativeQuery("SELECT * FROM student WHERE studentId=?1 || name=?2 ");
            query.addEntity(Student.class);
            query.setParameter(1, idOrName);
            query.setParameter(2, idOrName);

            return (Student) query.uniqueResult();
        }catch (Exception e){
            throw e;
        }finally {
            session.close();

        }

    }

    @Override
    public boolean update(Student student) throws Exception{
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            session.update(student);
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
    public boolean delete(String id) throws Exception{
        Session session = null;
        Transaction transaction = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            transaction = session.beginTransaction();

            session.remove(session.get(Student.class, id));
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
    public List<Student> getAll() throws Exception{
        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();
            NativeQuery query = session.createNativeQuery("SELECT * FROM student");
            query.addEntity(Student.class);
            return query.list();
        }catch (Exception e) {
            throw e;
        }finally {
            session.close();

        }

    }

}
