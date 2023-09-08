package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.ReservationDTO;
import dto.RoomDTO;
import dto.StudentDTO;
import dto.tm.StudentTM;
import entity.Room;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.List;

public class StudentsFormController {
    @FXML
    public ToggleGroup gender;

    @FXML
    public ToggleGroup status;

    @FXML
    public TableColumn<?, ?> dobCol;

    @FXML
    public TableColumn<?, ?> regDateCol;

    @FXML
    public TableColumn<?, ?> statusCol;

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
    private TableView<StudentTM> table;

    @FXML
    private TableColumn<?, ?> sidCol;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> addressCol;

    @FXML
    private TableColumn<?, ?> contactCol;

    @FXML
    private TableColumn<?, ?> genderCol;

    @FXML
    private TableColumn<?, ?> resIdCol;

    @FXML
    private TableColumn<?, ?> roomTypeIdCol;

    @FXML
    private TableColumn<?, ?> roomTypeCol;

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
    private JFXTextField resIdTxt;

    @FXML
    private JFXTextField resDateTxt;

    @FXML
    private JFXTextField roomIdTxt;

    @FXML
    private JFXTextField roomTypeTxt;

    @FXML
    private JFXTextField searchTxt;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton deleteBtn;

    StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.STUDENT);

    ReservationDTO selectedReservationDTO;
    StudentDTO selectedStudent;
    RoomDTO selectedRoom;


    @FXML
    public void initialize() {
        setCellValueFactory();
        loadStudentTableValues();
        setBtnsVisible(false);

    }


    private void setCellValueFactory() {
        sidCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        roomTypeIdCol.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        resIdCol.setCellValueFactory(new PropertyValueFactory<>("resId"));
        regDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
    }

    private void loadStudentTableValues() {
        ObservableList<StudentTM> obList = FXCollections.observableArrayList();
        try {
            List<ReservationDTO> allStudents = studentBO.getAllStudents();
            for (ReservationDTO reservation : allStudents) {
                StudentDTO student = reservation.getStudent();
                RoomDTO room = reservation.getRoom();
                obList.add(new StudentTM(student.getStudentId(), student.getName(), student.getAddress(), student.getContactNo(), student.getDob(), student.getGender(), reservation.getStatus(), room.getRoomTypeId(), room.getRoomType(), reservation.getResId(), reservation.getDate()));
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Data Loading Error !").show();
        }
        table.setItems(obList);
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        try {
            studentBO.deleteStudent(sidTxt.getText(), selectedRoom.getRoomTypeId());
            new Alert(Alert.AlertType.INFORMATION, "Student Deleted !").show();
            clearTxtFields();
            loadStudentTableValues();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Student Not Deleted !").show();
        }
    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {
        try {
            selectedReservationDTO = studentBO.searchStudent(searchTxt.getText());
            selectedStudent = selectedReservationDTO.getStudent();
            selectedRoom = selectedReservationDTO.getRoom();

            sidTxt.setText(selectedStudent.getStudentId());
            nameTxt.setText(selectedStudent.getName());
            addressTxt.setText(selectedStudent.getAddress());
            contactTxt.setText(selectedStudent.getContactNo());
            dobTxt.setText(selectedStudent.getDob() + "");
            roomIdTxt.setText(selectedRoom.getRoomTypeId());
            roomTypeTxt.setText(selectedRoom.getRoomType());
            resIdTxt.setText(selectedReservationDTO.getResId());
            resDateTxt.setText(selectedReservationDTO.getDate() + "");

            switch (selectedStudent.getGender()) {
                case "MALE":
                    maleRBtn.setSelected(true);
                    break;
                case "FEMALE":
                    femaleRBtn.setSelected(true);
                    break;
                case "OTHER":
                    otherRBtn.setSelected(true);
                    break;
                default:
            }

            switch (selectedReservationDTO.getStatus()) {
                case "PAID":
                    payNowRBtn.setSelected(true);
                    break;
                case "NOT PAID":
                    payLaterRBtn.setSelected(true);
                    break;
                default:
            }
            setBtnsVisible(true);

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Data Missing On This Id !").show();
        }

    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        try {
            ReservationDTO reservationDTO = new ReservationDTO();
            StudentDTO studentDTO = new StudentDTO();

            RadioButton genderRBtn = (RadioButton) gender.getSelectedToggle();
            RadioButton statusRBtn = (RadioButton) status.getSelectedToggle();

            studentDTO.setStudentId(sidTxt.getText());
            studentDTO.setName(nameTxt.getText());
            studentDTO.setAddress(addressTxt.getText());
            studentDTO.setContactNo(contactTxt.getText());
            studentDTO.setDob(LocalDate.parse(dobTxt.getText()));
            studentDTO.setGender(genderRBtn.getText());

            reservationDTO.setResId(selectedReservationDTO.getResId());
            reservationDTO.setDate(selectedReservationDTO.getDate());
            reservationDTO.setStatus(statusRBtn.getText());
            reservationDTO.setStudent(studentDTO);
            reservationDTO.setRoom(selectedRoom);


            studentBO.updateStudent(studentDTO, reservationDTO);
            new Alert(Alert.AlertType.INFORMATION, "Student Updated !");
            clearTxtFields();
            loadStudentTableValues();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Student Not Updated !").show();
        }


    }

    @FXML
    public void searchTxtOnAction(ActionEvent actionEvent) {
        searchBtnOnAction(actionEvent);
    }

    private void clearTxtFields() {
        sidTxt.clear();
        nameTxt.clear();
        addressTxt.clear();
        contactTxt.clear();
        dobTxt.clear();
        roomIdTxt.clear();
        roomTypeTxt.clear();
        resIdTxt.clear();
        resDateTxt.clear();

        setBtnsVisible(false);
        RadioButton genderRBtn = (RadioButton) gender.getSelectedToggle();
        RadioButton statusRBtn = (RadioButton) status.getSelectedToggle();
        genderRBtn.setSelected(false);
        statusRBtn.setSelected(false);

    }

    public void setBtnsVisible(boolean ok){
        if (ok) {
            updateBtn.setVisible(true);
            deleteBtn.setVisible(true);
        }else {
            updateBtn.setVisible(false);
            deleteBtn.setVisible(false);
        }

    }


}
