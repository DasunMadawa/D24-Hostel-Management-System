package bo.custom;

import bo.SuperBO;
import dto.ReservationDTO;
import dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    public List<ReservationDTO> getAllStudents() throws Exception;
    public ReservationDTO searchStudent(String id) throws Exception;
    public boolean updateStudent(StudentDTO studentDTO, ReservationDTO reservationDTO) throws Exception;
    public boolean deleteStudent(String studentId , String roomId) throws Exception;

}
