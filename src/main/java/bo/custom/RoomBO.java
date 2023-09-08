package bo.custom;

import bo.SuperBO;
import dto.ReservationDTO;
import dto.RoomDTO;
import dto.StudentDTO;

import java.util.List;

public interface RoomBO extends SuperBO {
    public List<RoomDTO> getAllRooms() throws Exception;
    public RoomDTO searchRoom(String id) throws Exception;
    public boolean updateRoom(RoomDTO roomDTO) throws Exception;
    public boolean deleteRoom(String id) throws Exception;
    public boolean addRoom(RoomDTO roomDTO) throws Exception;

}
