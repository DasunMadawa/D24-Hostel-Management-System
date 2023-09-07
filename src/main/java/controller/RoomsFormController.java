package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class RoomsFormController {

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> roomIdCol;

    @FXML
    private TableColumn<?, ?> roomTypeCol;

    @FXML
    private TableColumn<?, ?> keyMoneyCol;

    @FXML
    private TableColumn<?, ?> qtyCol;

    @FXML
    private JFXTextField roomIdTxt;

    @FXML
    private JFXTextField roomTypeTxt;

    @FXML
    private JFXTextField qtyTxt;

    @FXML
    private JFXTextField keyMoneyTxt;

    @FXML
    private JFXTextField searchTxt;

    @FXML
    private JFXButton serachBtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXButton addNewTypeBtn;

    @FXML
    void addNewTypeBtnOnAction(ActionEvent event) {

    }

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
