package dao.custom.impl;

import dao.CrudDAO;
import dao.custom.StudentDAO;
import entity.Room;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import util.FactoryConfiguration;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(student);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public Student search(String idOrName) throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        NativeQuery query = session.createNativeQuery("SELECT * FROM student WHERE studentId=?1 || studentName=?2 ");
        query.addEntity(Student.class);
        query.setParameter(1 , idOrName);
        query.setParameter(2 , idOrName);

        Student student = session.get(Student.class, idOrName);
        session.close();
        return student;
    }

    @Override
    public boolean update(Student student) throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);
        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Student> getAll() throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        NativeQuery query = session.createNativeQuery("SELECT * FROM student");
        query.addEntity(Student.class);
        List<Student> list = query.list();
        session.close();
        return list;
    }

}
