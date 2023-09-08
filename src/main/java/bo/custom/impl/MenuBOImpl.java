package bo.custom.impl;

import bo.custom.MenuBO;
import dao.DAOFactory;
import dao.custom.ReservationDAO;
import dao.custom.RoomDAO;
import dao.custom.StudentDAO;
import entity.Reservation;
import entity.Room;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class MenuBOImpl implements MenuBO {
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);

    @Override
    public int getTotalCap() throws Exception {
        List<Room> rooms = roomDAO.getAll();
        int cap = 0;
        for (Room room : rooms) {
            cap += room.getQty();

        }
        return cap;
    }

    @Override
    public int getActiveRes() throws Exception {
        List<Room> rooms = roomDAO.getAll();
        int cap = 0;
        for (Room room : rooms) {
            cap += room.getQty();

        }

        List<Student> students = studentDAO.getAll();
        int filled = students.size();
        return cap - filled;

    }

    @Override
    public int getTotalFilled() throws Exception {
        List<Student> students = studentDAO.getAll();
        return students.size();

    }

    @Override
    public double getKeyMoneyPer() throws Exception {
        List<Reservation> reservations = reservationDAO.getAll();
        int payedCount = 0;
        for (Reservation reservation : reservations) {
            payedCount += reservation.getStatus().equals("PAID") ? 1 : 0;
        }

        double all = reservations.size();
        return payedCount / all;

    }

    @Override
    public int[] getResChart() throws Exception {
        List<Object[]> resChart = reservationDAO.getResChart();
        ArrayList<Integer> list = new ArrayList<>();

        int[] ar = new int[12];

        for (Object[] objects : resChart) {
            int month = Integer.parseInt(objects[1]+"");
            ar[month-1] = Integer.parseInt(objects[0]+"");
        }
        return ar;

    }
}
