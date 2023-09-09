package bo.custom;

import bo.SuperBO;
import dto.UserDTO;

public interface LoginFormBO extends SuperBO {
    public boolean validPassword(UserDTO userDTO) throws Exception;
}
