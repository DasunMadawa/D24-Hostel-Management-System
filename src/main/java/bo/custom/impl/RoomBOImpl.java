package bo.custom.impl;

import bo.custom.RoomBO;
import dao.DAOFactory;
import dao.custom.ReservationDAO;
import dao.custom.RoomDAO;
import dto.RoomDTO;
import entity.Reservation;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    @Override
    public List<RoomDTO> getAllRooms() throws Exception {
        List<Room> all = roomDAO.getAll();
        List<RoomDTO> dtoList = new ArrayList<>();
        for (Room room : all) {
            dtoList.add(new RoomDTO(room.getRoomTypeId() , room.getRoomType() , room.getKeyMoney() , room.getQty() ));
        }

        return dtoList;

    }

    @Override
    public RoomDTO searchRoom(String id) throws Exception {
        Room room = roomDAO.search(id);
        return new RoomDTO(room.getRoomTypeId() , room.getRoomType() , room.getKeyMoney() , room.getQty() );

    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) throws Exception {
        List<Room> all = roomDAO.getAll();
        int count=0;
        for (Room room : all) {
            if (room.getRoomTypeId().equals(roomDTO.getRoomTypeId())){
                continue;
            }
            count += room.getQty();
        }

        if ((count+roomDTO.getQty()) > 125){
            throw new Exception();
        }
        roomDAO.update(new Room(roomDTO.getRoomTypeId() , roomDTO.getRoomType() , roomDTO.getKeyMoney() , roomDTO.getQty()));
        return true;

    }

    @Override
    public boolean deleteRoom(String id) throws Exception {
        List<Reservation> all = reservationDAO.getAll();
        int count=0;
        for (Reservation reservation : all) {
            if (reservation.getRoom().getRoomTypeId().equals(id)){
                throw new Exception();
            }
        }

        roomDAO.delete(id);
        return true;
    }

    @Override
    public boolean addRoom(RoomDTO roomDTO) throws Exception {
        List<Room> all = roomDAO.getAll();
        int count=0;
        for (Room room : all) {
            count+= room.getQty();
        }
        if ((count+ roomDTO.getQty() > 125)){
            throw new Exception();
        }

        roomDAO.add(new Room(roomDTO.getRoomTypeId() , roomDTO.getRoomType() , roomDTO.getKeyMoney() , roomDTO.getQty()));
        return false;
    }

}
