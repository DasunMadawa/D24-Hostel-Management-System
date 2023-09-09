package bo.custom.impl;

import bo.SuperBO;
import bo.custom.UserBO;
import dao.DAOFactory;
import dao.custom.UserDAO;
import dto.UserDTO;
import entity.User;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        if (userDTO.getPassword().equals(userDTO.getConfirm())) {
            return userDAO.update(new User(userDTO.getUserName(), userDTO.getPassword()));
        }
        throw new Exception();
    }

}
