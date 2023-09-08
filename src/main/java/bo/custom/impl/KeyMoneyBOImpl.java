package bo.custom.impl;

import bo.custom.KeyMoneyBO;
import dao.DAOFactory;
import dao.custom.QueryDAO;

import java.util.List;

public class KeyMoneyBOImpl implements KeyMoneyBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    @Override
    public List<Object[]> getAllStudents() throws Exception {
        return queryDAO.getNotPaidStudents();
    }

    @Override
    public Object[] searchStudent(String id) throws Exception {
        return queryDAO.searchStudentsStatus(id);
    }

}
