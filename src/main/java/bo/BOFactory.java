package bo;

import bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBOFactory(){
        return boFactory == null ? boFactory = new BOFactory():boFactory;

    }

    public enum BOTypes {
        STUDENT , ROOM , RESERVATION , USER , MENU , KEY
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes) {
            case STUDENT: return new StudentBOImpl();
            case ROOM: return new RoomBOImpl();
            case USER: return new UserBOImpl();
            case RESERVATION: return new ReservationBOImpl();
            case MENU:return new MenuBOImpl();
            case KEY:return new KeyMoneyBOImpl();
            default: return null;

        }

    }


}
