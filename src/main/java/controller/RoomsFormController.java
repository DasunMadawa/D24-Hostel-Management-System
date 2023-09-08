package controller;

import bo.BOFactory;
import bo.custom.RoomBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dto.ReservationDTO;
import dto.RoomDTO;
import dto.StudentDTO;
import dto.tm.RoomTM;
import dto.tm.StudentTM;
import entity.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class RoomsFormController {

    @FXML
    private TableView<RoomTM> table;

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
    private JFXButton searchBtn;

    @FXML
    private JFXButton updateBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXButton addNewTypeBtn;

    RoomBO roomBO = (RoomBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ROOM);

    @FXML
    public void initialize(){
        setCellValueFactory();
        loadRoomTableValues();
        clear();

    }

    private void setCellValueFactory() {
        roomIdCol.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        keyMoneyCol.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    private void loadRoomTableValues() {
        ObservableList<RoomTM> obList = FXCollections.observableArrayList();
        try {
            List<RoomDTO> allRooms = roomBO.getAllRooms();
            for (RoomDTO roomDTO : allRooms) {
                obList.add(new RoomTM(roomDTO.getRoomTypeId() , roomDTO.getRoomType() , roomDTO.getKeyMoney() , roomDTO.getQty()));
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Data Loading Error !").show();
        }
        table.setItems(obList);
    }

    @FXML
    void addNewTypeBtnOnAction(ActionEvent event) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomTypeId(roomIdTxt.getText());
        roomDTO.setRoomType(roomTypeTxt.getText());
        roomDTO.setKeyMoney(keyMoneyTxt.getText());
        roomDTO.setQty(Integer.parseInt(qtyTxt.getText()));

        try {
            roomBO.addRoom(roomDTO);
            new Alert(Alert.AlertType.INFORMATION, "New Room Type Added !").show();
            clear();
            loadRoomTableValues();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Room Type Not Added ! Check Spaces Or Duplicate Ids").show();
        }
    }

    @FXML
    void deleteBtnOnAction(ActionEvent event) {
        try {
            roomBO.deleteRoom(roomIdTxt.getText());
            new Alert(Alert.AlertType.INFORMATION, "Room Type Deleted!").show();
            clear();
            loadRoomTableValues();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Room Type Not Deleted ! Already in use").show();
        }
    }


    @FXML
    void searchBtnOnAction(ActionEvent event) {
        try {
            RoomDTO roomDTO = roomBO.searchRoom(searchTxt.getText());

            roomIdTxt.setText(roomDTO.getRoomTypeId());
            roomTypeTxt.setText(roomDTO.getRoomType());
            keyMoneyTxt.setText(roomDTO.getKeyMoney());
            qtyTxt.setText(roomDTO.getQty()+"");
            setBtnsVisible(true);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Data Missing On This Id !").show();
        }
    }

    @FXML
    void updateBtnOnAction(ActionEvent event) {
        try {
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setRoomTypeId(roomIdTxt.getText());
            roomDTO.setRoomType(roomTypeTxt.getText());
            roomDTO.setKeyMoney(keyMoneyTxt.getText());
            roomDTO.setQty(Integer.parseInt(qtyTxt.getText()));

            roomBO.updateRoom(roomDTO);
            new Alert(Alert.AlertType.INFORMATION, "Updated!").show();
            clear();
            loadRoomTableValues();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Not Updated ! Check Space Or Duplicate Ids").show();
        }
    }

    @FXML
    public void searchTxtOnAction(ActionEvent actionEvent) {
        searchBtnOnAction(actionEvent);
    }

    private void clear() {
        roomIdTxt.clear();
        roomTypeTxt.clear();
        keyMoneyTxt.clear();
        qtyTxt.clear();

        setBtnsVisible(false);

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
