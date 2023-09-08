package controller;

import bo.BOFactory;
import bo.custom.ReservationBO;
import bo.custom.RoomBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dao.custom.RoomDAO;
import dto.ReservationDTO;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationFormController {

    @FXML
    public JFXRadioButton maleRBtn;

    @FXML
    public JFXRadioButton femaleRBtn;

    @FXML
    public JFXRadioButton otherRBtn;

    @FXML
    public JFXRadioButton payNowRBtn;

    @FXML
    public JFXRadioButton payLaterRBtn;

    @FXML
    public ToggleGroup gender;

    @FXML
    public ToggleGroup status;

    @FXML
    private JFXTextField sidTxt;

    @FXML
    private JFXTextField nameTxt;

    @FXML
    private JFXTextField addressTxt;

    @FXML
    private JFXTextField contactTxt;

    @FXML
    private JFXTextField dobTxt;

    @FXML
    private JFXTextField resDateTxt;

    @FXML
    private JFXTextField roomTypeTxt;

    @FXML
    private JFXTextField resIdTxt;

    @FXML
    private JFXButton registerBtn;

    @FXML
    private JFXComboBox<String> roomIdComboBox;

    ReservationBO reservationBO = (ReservationBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.RESERVATION);

    @FXML
    public void initialize() {
        init();

    }

    public void init() {
        try {
            String nextId = reservationBO.genarateResId();
            resIdTxt.setText(nextId);
            resDateTxt.setText(LocalDate.now() + "");

            ObservableList<String> obList = FXCollections.observableArrayList();
            List<RoomDTO> roomList = reservationBO.getAllRooms();
            for (RoomDTO roomDTO : roomList) {
                obList.add(roomDTO.getRoomTypeId());
            }

            roomIdComboBox.setItems(obList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void registerBtnOnAction(ActionEvent event) {
        ReservationDTO reservationDTO = new ReservationDTO();
        ToggleButton statusRBtn = (ToggleButton) status.getSelectedToggle();
        ToggleButton genderRBtn = (ToggleButton) gender.getSelectedToggle();

        reservationDTO.setResId(resIdTxt.getText());
        reservationDTO.setDate(LocalDate.now());
        reservationDTO.setStatus(statusRBtn.getText());

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setStudentId(sidTxt.getText());
        studentDTO.setName(nameTxt.getText());
        studentDTO.setAddress(addressTxt.getText());
        studentDTO.setContactNo(contactTxt.getText());
        studentDTO.setDob(LocalDate.parse(dobTxt.getText()));
        studentDTO.setGender(genderRBtn.getText());
        List<ReservationDTO> resList = new ArrayList();
        resList.add(reservationDTO);

        studentDTO.setReservations(resList);

        reservationDTO.setStudent(studentDTO);

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomTypeId(roomIdComboBox.getValue());

        reservationDTO.setRoom(roomDTO);
        try {
            reservationBO.registration(reservationDTO);
            new Alert(Alert.AlertType.INFORMATION, "Registered !", ButtonType.OK).show();
            clear();
        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION, "Not Registered !", ButtonType.OK).show();
            e.printStackTrace();
        }


    }

    @FXML
    public void roomIdComboBoxOnACtion(ActionEvent actionEvent) {

    }

    private void clear() {
        sidTxt.clear();
        nameTxt.clear();
        addressTxt.clear();
        contactTxt.clear();
        dobTxt.clear();
        roomTypeTxt.clear();

        RadioButton genderRBtn = (RadioButton) gender.getSelectedToggle();
        RadioButton statusRBtn = (RadioButton) status.getSelectedToggle();
        genderRBtn.setSelected(false);
        statusRBtn.setSelected(false);

    }

}
