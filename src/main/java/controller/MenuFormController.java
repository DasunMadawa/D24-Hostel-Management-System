package controller;

import bo.BOFactory;
import bo.custom.MenuBO;
import com.jfoenix.controls.JFXSpinner;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

public class MenuFormController {
    @FXML
    public CategoryAxis monthAxixX;

    @FXML
    public NumberAxis reservationAxixY;

    @FXML
    private Label totalCapLbl;

    @FXML
    private Label activeLbl;

    @FXML
    private Label filledLbl;

    @FXML
    private JFXSpinner keyMoneySpinner;

    @FXML
    private LineChart<?, ?> lineChart;

    MenuBO menuBO = (MenuBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.MENU);

    @FXML
    public void initialize() {

        try {
            totalCapLbl.setText(menuBO.getTotalCap() + "");
            activeLbl.setText(menuBO.getActiveRes() + "");
            filledLbl.setText(menuBO.getTotalFilled() + "");
            keyMoneySpinner.setProgress(menuBO.getKeyMoneyPer());
            int[] resChart = menuBO.getResChart();

            XYChart.Series series = new XYChart.Series();
            for (int i = 0; i < 12; i++) {
                series.getData().add(new XYChart.Data((i + 1)+"" , resChart[i]));

            }
            lineChart.getData().add(series);


        } catch (Exception e) {
            System.out.println(e);
        }


    }

}
