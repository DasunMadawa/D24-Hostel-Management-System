package dao.custom.impl;

import dao.custom.QueryDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.util.Arrays;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public List<Object[]> getNotPaidStudents() {
        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();

            Query query = session.createQuery("select s.studentId , s.name , r.status from Student s inner join Reservation r on s = r.student where r.status = 'NOT PAID'");
            return query.list();

        }catch (Exception e) {
            throw e;
        }finally {
            session.close();
        }

    }

    @Override
    public Object[] searchStudentsStatus(String id) {
        Session session = null;
        try {
            session = FactoryConfiguration.getInstance().getSession();

            Query query = session.createQuery("select s.studentId , s.name , r.status from Student s inner join Reservation r on s = r.student where s.studentId =?1");
            query.setParameter(1 , id);
            return (Object[]) query.uniqueResult();

        }catch (Exception e) {
            throw e;
        }finally {
            session.close();
        }
    }


}
