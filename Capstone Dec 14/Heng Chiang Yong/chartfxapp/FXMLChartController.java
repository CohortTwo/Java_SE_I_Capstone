/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartfxapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author chiangyong
 */
public class FXMLChartController implements Initializable {

    @FXML
    private TextField salThree;
    @FXML
    private TextField salOne;
    @FXML
    private TextField nameOne;
    @FXML
    private TextField nameTwo;
    @FXML
    private TextField nameThree;
    @FXML
    private TextField nameFive;
    @FXML
    private TextField nameFour;
    @FXML
    private TextField salTwo;
    @FXML
    private TextField salFour;
    @FXML
    private TextField salFive;
    @FXML
    private CategoryAxis barChart;
    @FXML
    private BarChart<?, ?> perfChart;
    @FXML
    private Button refreshBtn;
    @FXML
    private GridPane gridPlane1;
    @FXML
    private PieChart pieChart;

    
    
    @FXML
    public void ShowBarChart()
    {
        XYChart.Series set = new XYChart.Series<>();
        set.getData().add(new XYChart.Data(nameOne.getText(),Integer.parseInt(salOne.getText())));
        set.getData().add(new XYChart.Data(nameTwo.getText(),Integer.parseInt(salTwo.getText())));
        set.getData().add(new XYChart.Data(nameThree.getText(),Integer.parseInt(salThree.getText())));
        set.getData().add(new XYChart.Data(nameFour.getText(),Integer.parseInt(salFour.getText())));
        set.getData().add(new XYChart.Data(nameFive.getText(),Integer.parseInt(salFive.getText())));
        
        perfChart.getData().addAll(set);
    }
    
    public void ShowPieChart()
    {
        ObservableList<PieChart.Data> piedata =
                FXCollections.observableArrayList(
      new PieChart.Data(nameOne.getText(),Integer.parseInt(salOne.getText())),
        new PieChart.Data(nameTwo.getText(),Integer.parseInt(salTwo.getText())),
        new PieChart.Data(nameThree.getText(),Integer.parseInt(salThree.getText())),
        new PieChart.Data(nameFour.getText(),Integer.parseInt(salFour.getText())),
       new PieChart.Data(nameFive.getText(),Integer.parseInt(salFive.getText())));
        
        pieChart.setData(piedata);
    }
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ShowBarChart();
        ShowPieChart();
    }    
    
}
