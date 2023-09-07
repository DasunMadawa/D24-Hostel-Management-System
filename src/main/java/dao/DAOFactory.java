package dao;

import dao.custom.impl.ReservationDAOImpl;
import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDAOFactory(){
        return daoFactory == null ? daoFactory=new DAOFactory():daoFactory;
    }

    public enum DAOTypes {
        STUDENT , ROOM , RESERVATION , USER
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes) {
            case STUDENT: return new StudentDAOImpl();
            case ROOM: return new RoomDAOImpl();
            case USER: return new UserDAOImpl();
            case RESERVATION: return new ReservationDAOImpl();
            default: return null;

        }

    }


}
