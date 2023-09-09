package controller;

import bo.BOFactory;
import bo.custom.LoginFormBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginFormController {

    @FXML
    public AnchorPane root;

    @FXML
    private JFXTextField userNameTxt;

    @FXML
    private JFXPasswordField passwordTxt;

    @FXML
    private JFXButton loginBtn;

    LoginFormBO loginFormBO = (LoginFormBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.LOGIN);

    @FXML
    void loginBtnOnAction(ActionEvent event) {
        try {
            boolean isValid = loginFormBO.validPassword(new UserDTO(userNameTxt.getText(), passwordTxt.getText()));

            if (!isValid){
                System.out.println("Error 1111111111");
                throw new Exception();
            }
            DashboardFormController.userName = userNameTxt.getText();

            Stage primaryStage = (Stage) root.getScene().getWindow();

            primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"))));
            primaryStage.setResizable(false);
            primaryStage.setTitle("D24");
            primaryStage.getIcons().add(new Image("view/img/icons8-hostel-100.png"));
            primaryStage.show();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Invalid Username Or Password !" , ButtonType.OK).show();
            e.printStackTrace();
        }

    }

    @FXML
    void passwordTxtOnAction(ActionEvent event) {
        loginBtnOnAction(event);
    }

    @FXML
    void userNameTxtOnAction(ActionEvent event) {
        loginBtnOnAction(event);
    }

}
