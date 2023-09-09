package bo.custom.impl;

import bo.custom.LoginFormBO;
import dao.DAOFactory;
import dao.custom.UserDAO;
import dto.UserDTO;
import entity.User;

public class LoginFormBOImpl implements LoginFormBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean validPassword(UserDTO userDTO) throws Exception {
        User user = userDAO.search(userDTO.getUserName());
        System.out.println(user.getPassword());
        System.out.println(userDTO.getPassword());

        return user.getPassword().equals(userDTO.getPassword()) ? true:false;

    }

}
