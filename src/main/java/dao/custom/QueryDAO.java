package dao.custom;

import dao.SuperDAO;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    public List<Object[]> getNotPaidStudents();
    public Object[] searchStudentsStatus(String id);

}
