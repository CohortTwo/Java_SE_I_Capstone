/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 * @author sridh
 */
public class FXMLDocumentController implements Initializable {

    int chtype = 0;
    @FXML
    private BarChart<?, ?> barsal;
    @FXML
    private NumberAxis ysal;
    @FXML
    private CategoryAxis xemp;
    @FXML
    private TextField txte1;
    @FXML
    private TextField txtesal5;
    @FXML
    private TextField txte3;
    @FXML
    private TextField txtesal3;
    @FXML
    private TextField txte4;
    @FXML
    private TextField txtesal2;
    @FXML
    private TextField txtesal1;
    @FXML
    private TextField txtesal4;
    @FXML
    private TextField txte5;
    @FXML
    private TextField txte2;
    @FXML
    private Button btnrefresh;
    @FXML
    private PieChart piesal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ShowDataBar();
    }

    @FXML
    public void ShowDataBar() {

//        set.getData().add(new XYChart.Data("James",3000));
//        set.getData().add(new XYChart.Data("Jame",300));
//        set.getData().add(new XYChart.Data("John",4000));
//        set.getData().add(new XYChart.Data("Simon",2000));
        Double d1 = Double.parseDouble(txtesal1.getText());
        Double d2 = Double.parseDouble(txtesal2.getText());
        Double d3 = Double.parseDouble(txtesal3.getText());
        Double d4 = Double.parseDouble(txtesal4.getText());
        Double d5 = Double.parseDouble(txtesal5.getText());

        XYChart.Series set = new XYChart.Series<>();
        barsal.getData().clear();

        set.getData().add(new XYChart.Data(txte1.getText(), d1));
        set.getData().add(new XYChart.Data(txte2.getText(), d2));
        set.getData().add(new XYChart.Data(txte3.getText(), d3));
        set.getData().add(new XYChart.Data(txte4.getText(), d4));
        set.getData().add(new XYChart.Data(txte5.getText(), d5));

        barsal.getData().addAll(set);

        ObservableList<PieChart.Data> piedata
                = FXCollections.observableArrayList(
                        new PieChart.Data(txte1.getText(), d1),
                        new PieChart.Data(txte2.getText(), d2),
                        new PieChart.Data(txte3.getText(), d3),
                        new PieChart.Data(txte4.getText(), d4),
                        new PieChart.Data(txte5.getText(), d5));

        piesal.setData(piedata);

        //          Add data to a line chart        
//        XYChart.Series series = new XYChart.Series();
//
//        series.getData().add(new XYChart.Data("Simon", 20));
//        series.getData().add(new XYChart.Data("John", 10));
//        series.getData().add(new XYChart.Data("Alex", 40));
//        series.getData().add(new XYChart.Data("Andrew", 30));
//
//        XYChart.Series series1 = new XYChart.Series();
//
//        series1.getData().add(new XYChart.Data("Simon", 120));
//        series1.getData().add(new XYChart.Data("John", 110));
//        series1.getData().add(new XYChart.Data("Alex", 140));
//        series1.getData().add(new XYChart.Data("Andrew", 130));
//
//        XYChart.Series series2 = new XYChart.Series();
//
//        series2.getData().add(new XYChart.Data("Simon", 220));
//        series2.getData().add(new XYChart.Data("John", 210));
//        series2.getData().add(new XYChart.Data("Alex", 240));
//        series2.getData().add(new XYChart.Data("Andrew", 230));
//
//        lchart.getData().addAll(series, series1, series2);
    }
}
