package dto;

import entity.Reservation;

import java.util.ArrayList;
import java.util.List;

public class RoomDTO {
    private String roomTypeId;
    private String roomType;
    private String keyMoney;
    private int qty;

    private List<Reservation> reservations;

    public RoomDTO() {

    }

    public RoomDTO(String roomTypeId, String roomType, String keyMoney, int qty) {
        this.roomTypeId = roomTypeId;
        this.roomType = roomType;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

    public RoomDTO(String roomTypeId, String roomType, String keyMoney, int qty, List<Reservation> reservations) {
        this.roomTypeId = roomTypeId;
        this.roomType = roomType;
        this.keyMoney = keyMoney;
        this.qty = qty;
        this.reservations = reservations;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(String keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
