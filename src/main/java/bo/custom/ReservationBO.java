package bo.custom;

import bo.SuperBO;
import dto.ReservationDTO;
import dto.RoomDTO;

import java.util.List;

public interface ReservationBO extends SuperBO {
    public boolean registration(ReservationDTO reservationDTO) throws Exception;
    public String genarateResId() throws Exception;
    public List<RoomDTO> getAllRooms() throws Exception;

}
