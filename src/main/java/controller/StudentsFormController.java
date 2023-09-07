package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StudentsFormController {

    @FXML
    private TableView<?> table;

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
    private TableColumn<?, ?> reservationCol;

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
    private JFXTextField genderTxt;

    @FXML
    private JFXTextField resIdTxt;

    @FXML
    private JFXTextField resDateTxt;

    @FXML
    private JFXTextField statusTxt;

    @FXML
    private JFXTextField roomIdTxt;

    @FXML
    private JFXTextField roomTypeTxt;

    @FXML
    private JFXTextField searchTxt;

    @FXML
    private JFXButton serachBtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    @FXML
    void serachBtnOnAction(ActionEvent event) {

    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {

    }

}
