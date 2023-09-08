package dto;

import entity.Room;
import entity.Student;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class ReservationDTO {
    private String resId;
    private LocalDate date;
    private String status;

    private StudentDTO student;
    private RoomDTO room;

    public ReservationDTO() {

    }

    public ReservationDTO(String resId, LocalDate date, String status) {
        this.resId = resId;
        this.date = date;
        this.status = status;
    }

    public ReservationDTO(String resId, LocalDate date, String status, StudentDTO student, RoomDTO room) {
        this.resId = resId;
        this.date = date;
        this.status = status;
        this.student = student;
        this.room = room;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }

}
