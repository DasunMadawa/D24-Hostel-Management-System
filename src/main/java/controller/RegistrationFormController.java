package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class RegistrationFormController {

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
    private JFXTextField resDateTxt;

    @FXML
    private JFXTextField statusTxt;

    @FXML
    private JFXTextField roomTypeTxt;

    @FXML
    private JFXTextField resIdTxt;

    @FXML
    private JFXButton registerBtn;

    @FXML
    private JFXComboBox<?> roomIdComboBox;

    @FXML
    void registerBtnOnAction(ActionEvent event) {

    }

}
