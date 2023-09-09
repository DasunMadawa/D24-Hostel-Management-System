package controller;

import bo.BOFactory;
import bo.custom.UserBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class UserFormController {

    @FXML
    private JFXButton changeBtn;

    @FXML
    private JFXTextField userNameTxt;

    @FXML
    private JFXTextField passwordText;

    @FXML
    private JFXTextField confirmText;

    UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);


    @FXML
    void changeBtnOnAction(ActionEvent event) {
        try {
            userBO.update(new UserDTO(userNameTxt.getText() , passwordText.getText() , confirmText.getText()));
            new Alert(Alert.AlertType.INFORMATION , "Updated !" , ButtonType.OK ).show();

            userNameTxt.clear();
            passwordText.clear();
            confirmText.clear();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR , "Not Updated !" , ButtonType.OK ).show();
        }

    }

    @FXML
    void confirmTextOnAction(ActionEvent event) {
        changeBtnOnAction(event);
    }

    @FXML
    void passwordTextOnAction(ActionEvent event) {
        changeBtnOnAction(event);
    }

    @FXML
    void userNameTxtOnAction(ActionEvent event) {
        changeBtnOnAction(event);
    }

}
