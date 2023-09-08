package controller;

import bo.BOFactory;
import bo.custom.KeyMoneyBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.tm.KeyMoneyTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class KeyMoneyFormController {

    @FXML
    private TableView<KeyMoneyTM> table;

    @FXML
    private TableColumn<?, ?> studentIdCol;

    @FXML
    private TableColumn<?, ?> studentNameCol;

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

    KeyMoneyBO keyMoneyBO = (KeyMoneyBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.KEY);

    @FXML
    public void initialize(){
        setCellValueFactory();
        setValuesToTable();

    }

    private void setValuesToTable() {
        ObservableList<KeyMoneyTM> obList = FXCollections.observableArrayList();
        try {
            List<Object[]> allStudents = keyMoneyBO.getAllStudents();
            for (Object[] student : allStudents) {
                obList.add(new KeyMoneyTM(student[0]+"" , student[1]+"" , student[2]+""));
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR , e.getMessage() , ButtonType.OK).show();
        }
        table.setItems(obList);

    }

    private void setCellValueFactory() {
        studentIdCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    @FXML
    void serachBtnOnAction(ActionEvent event) {
        try {
            Object[] objects = keyMoneyBO.searchStudent(searchTxt.getText());

            nameTxt.setText(objects[1]+"");
            statusTxt.setText(objects[2]+"");
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR , "check id" , ButtonType.OK).show();
        }

    }

    @FXML
    public void searchTxtOnAction(ActionEvent actionEvent) {
        serachBtnOnAction(actionEvent);
    }

}
