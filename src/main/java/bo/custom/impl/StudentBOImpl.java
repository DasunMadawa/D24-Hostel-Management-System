package bo.custom.impl;

import bo.custom.StudentBO;
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

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public List<ReservationDTO> getAllStudents() throws Exception {
        List<Reservation> all = reservationDAO.getAll();
        List<ReservationDTO> list = new ArrayList<>();

        for (Reservation reservation : all) {
            Student student = reservation.getStudent();
            StudentDTO studentDTO = new StudentDTO(student.getStudentId(), student.getName(), student.getAddress(), student.getContactNo(), student.getDob(), student.getGender());
            Room room = reservation.getRoom();
            RoomDTO roomDTO = new RoomDTO(room.getRoomTypeId(), room.getRoomType(), room.getKeyMoney(), room.getQty());

            list.add(new ReservationDTO(reservation.getResId(), reservation.getDate(), reservation.getStatus(), studentDTO , roomDTO));
        }
        return list;

    }

    @Override
    public ReservationDTO searchStudent(String id) throws Exception {
        Student student = studentDAO.search(id);
        StudentDTO studentDTO = new StudentDTO(student.getStudentId(), student.getName(), student.getAddress(), student.getContactNo(), student.getDob(), student.getGender());

        List<Reservation> reservations = student.getReservations();
        Reservation reservation = reservationDAO.search(reservations.get(0).getResId());


        Room room = reservation.getRoom();
        RoomDTO roomDTO = new RoomDTO(room.getRoomTypeId(), room.getRoomType(), room.getKeyMoney(), room.getQty());

        return new ReservationDTO(reservation.getResId(), reservation.getDate(), reservation.getStatus(), studentDTO, roomDTO);

    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO, ReservationDTO reservationDTO) throws Exception {
        studentDAO.update(new Student(studentDTO.getStudentId(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getContactNo(), studentDTO.getDob(), studentDTO.getGender()));
        StudentDTO student = reservationDTO.getStudent();
        Student studentEntity = new Student(student.getStudentId(), student.getName(), student.getAddress(), student.getContactNo(), student.getDob(), student.getGender());

        RoomDTO roomDTO = reservationDTO.getRoom();
        Room roomEntity = new Room(roomDTO.getRoomTypeId(), roomDTO.getRoomType(), roomDTO.getKeyMoney(), roomDTO.getQty());
        reservationDAO.update(new Reservation(reservationDTO.getResId(), reservationDTO.getDate(), reservationDTO.getStatus() , studentEntity , roomEntity));
        return true;
    }

    @Override
    public boolean deleteStudent(String studentId , String roomId) throws Exception {
        studentDAO.delete(studentId);

        Room room = roomDAO.search(roomId);
        room.setQty(room.getQty()+1);
        roomDAO.update(room);

        return true;
    }

}
