package bo.custom.impl;

import bo.custom.ReservationBO;
import dao.DAOFactory;
import dao.custom.ReservationDAO;
import dao.custom.RoomDAO;
import dao.custom.StudentDAO;
import dto.ReservationDTO;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Reservation;
import entity.Room;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean registration(ReservationDTO reservationDTO) throws Exception {
//        RoomDTO roomDTO = reservationDTO.getRoom();
//        StudentDTO studentDTO = reservationDTO.getStudent();
//
//        Room room = roomDAO.search(roomDTO.getRoomTypeId());
//        room.setQty(room.getQty()-1);
//
//        Student student = new Student(studentDTO.getStudentId() , studentDTO.getName() , studentDTO.getAddress() , studentDTO.getContactNo() , studentDTO.getDob() , studentDTO.getGender() , reservationList);
//        Reservation reservation = new Reservation(reservationDTO.getResId() , reservationDTO.getDate() , reservationDTO.getStatus() , student , room);
        StudentDTO studentDTO = reservationDTO.getStudent();
        Student studentEntity = new Student(studentDTO.getStudentId(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getContactNo(), studentDTO.getDob(), studentDTO.getGender());
        boolean student = studentDAO.add(studentEntity);

        if (student){
            RoomDTO roomDTO = reservationDTO.getRoom();

            Room room = roomDAO.search(roomDTO.getRoomTypeId());
            room.setQty(room.getQty()-1);

            boolean res = reservationDAO.add(new Reservation(reservationDTO.getResId(), reservationDTO.getDate(), reservationDTO.getStatus(), studentEntity, room));

            if (res) {
                return roomDAO.update(room);

            }

        }

        return false;
    }

    @Override
    public String genarateResId() throws Exception {
        List<Reservation> all = reservationDAO.getAll();
        Reservation reservation = all.get(all.size() - 1);
        String lastID = reservation.getResId();
        return String.format("RE%03d", Integer.parseInt(lastID.substring(2)) +1 );
    }

    @Override
    public List<RoomDTO> getAllRooms() throws Exception {
        List<Room> all = roomDAO.getAll();
        List<RoomDTO> roomDTOList = new ArrayList<>();
        for (Room room : all) {
            roomDTOList.add(new RoomDTO(room.getRoomTypeId() , room.getRoomType() , room.getKeyMoney() , room.getQty()));
        }
        return roomDTOList;
    }


}
