package bo.custom;

import bo.SuperBO;
import dto.UserDTO;

public interface UserBO extends SuperBO {
    public boolean update(UserDTO userDTO) throws Exception;

}
