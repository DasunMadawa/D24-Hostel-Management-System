package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;
import entity.Student;

import java.util.List;

public interface KeyMoneyBO extends SuperBO {
    public List<Object[]> getAllStudents() throws Exception;
    public Object[] searchStudent(String id) throws Exception;

}
