package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class KeyMoneyFormController {

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> studentIdCol;

    @FXML
    private TableColumn<?, ?> studentNameCol;

    @FXML
    private TableColumn<?, ?> keyMoneyCol;

    @FXML
    private TableColumn<?, ?> statusCol;

    @FXML
    private JFXTextField nameTxt;

    @FXML
    private JFXTextField valueTxt;

    @FXML
    private JFXTextField searchTxt;

    @FXML
    private JFXButton serachBtn;

    @FXML
    private JFXTextField statusTxt;

    @FXML
    void serachBtnOnAction(ActionEvent event) {

    }

}
