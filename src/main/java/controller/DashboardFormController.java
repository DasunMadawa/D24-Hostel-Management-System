package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class DashboardFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton mainMenuBtn;

    @FXML
    private JFXButton studentsBtn;

    @FXML
    private ImageView studentsImageView;

    @FXML
    private JFXButton roomsBtn;

    @FXML
    private ImageView roomsImageView;

    @FXML
    private JFXButton keyMoneyBtn;

    @FXML
    private ImageView keyMoneyImageView;

    @FXML
    private JFXButton registerBtn;

    @FXML
    private ImageView registrationImageView;

    @FXML
    private AnchorPane dashboardAnc;

    @FXML
    private Text titleLbl;

    @FXML
    private Text userNameLbl;

    public static String userName;

    @FXML
    public void initialize(){
        userNameLbl.setText(userName);
        try {
            dashboardAnc.getChildren().clear();
            dashboardAnc.getChildren().add(FXMLLoader.load(getClass().getResource("/view/menu_form.fxml")));
        } catch (IOException e) {
//            new Alert(Alert.AlertType.ERROR , "UI Loading Bug" , ButtonType.OK).show();
        }

    }

    @FXML
    public void mainMenuBtnOnAction(ActionEvent actionEvent) {
        try {
            dashboardAnc.getChildren().clear();
            dashboardAnc.getChildren().add(FXMLLoader.load(getClass().getResource("/view/menu_form.fxml")));
        } catch (IOException e) {
//            new Alert(Alert.AlertType.ERROR , "UI Loading Bug" , ButtonType.OK).show();
        }
    }

    @FXML
    public void studentsBtnOnAction(ActionEvent actionEvent) {
        try {
            dashboardAnc.getChildren().clear();
            dashboardAnc.getChildren().add(FXMLLoader.load(getClass().getResource("/view/students_form.fxml")));
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR , "UI Loading Bug" , ButtonType.OK).show();
        }
    }

    @FXML
    public void roomsBtnOnAction(ActionEvent actionEvent) {
        try {
            dashboardAnc.getChildren().clear();
            dashboardAnc.getChildren().add(FXMLLoader.load(getClass().getResource("/view/rooms_form.fxml")));
        } catch (IOException e) {
//            new Alert(Alert.AlertType.ERROR , "UI Loading Bug" , ButtonType.OK).show();
        }
    }

    @FXML
    public void keyMoneyBtnOnAction(ActionEvent actionEvent) {
        try {
            dashboardAnc.getChildren().clear();
            dashboardAnc.getChildren().add(FXMLLoader.load(getClass().getResource("/view/key_money_form.fxml")));
        } catch (IOException e) {
//            new Alert(Alert.AlertType.ERROR , "UI Loading Bug" , ButtonType.OK).show();
        }
    }
    @FXML
    public void registerBtnOnAction(ActionEvent actionEvent) {
        try {
            dashboardAnc.getChildren().clear();
            dashboardAnc.getChildren().add(FXMLLoader.load(getClass().getResource("/view/registration_form.fxml")));
        } catch (IOException e) {
//            new Alert(Alert.AlertType.ERROR , "UI Loading Bug" , ButtonType.OK).show();
        }
    }
    @FXML
    public void userChangeOnMouseClicked(MouseEvent mouseEvent) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/user_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
