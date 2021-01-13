/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxchart;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author blueg
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private BarChart<?, ?> bar;
    @FXML
    private CategoryAxis labelemp1;
    @FXML
    private NumberAxis labelsal1;
    @FXML
    private Button refresh;
    @FXML
    private TextField ename1;
    @FXML
    private TextField esal1;
    @FXML
    private TextField ename2;
    @FXML
    private TextField esal2;
    @FXML
    private TextField ename3;
    @FXML
    private TextField esal3;
    @FXML
    private TextField ename4;
    @FXML
    private TextField esal4;
    @FXML
    private Label labelemp2;
    @FXML
    private Label labelsal2;
    @FXML
    private PieChart piechart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showCharts();
    }    

    @FXML
    private void showCharts() {
        XYChart.Series data = new XYChart.Series<>();
        
        bar.getData().clear();
        
        data.getData().add(new XYChart.Data<>(ename1.getText(),Double.parseDouble(esal1.getText())));
        data.getData().add(new XYChart.Data<>(ename2.getText(),Double.parseDouble(esal2.getText())));
        data.getData().add(new XYChart.Data<>(ename3.getText(),Double.parseDouble(esal3.getText())));
        data.getData().add(new XYChart.Data<>(ename4.getText(),Double.parseDouble(esal4.getText())));
        
        bar.getData().addAll(data);
        
        double sum = Double.parseDouble(esal1.getText()) +
                Double.parseDouble(esal2.getText()) +
                Double.parseDouble(esal3.getText()) +
                Double.parseDouble(esal4.getText());
        
        ObservableList<PieChart.Data> datapie = FXCollections.observableArrayList(
                new PieChart.Data(ename1.getText(),Double.parseDouble(esal1.getText())),
                new PieChart.Data(ename2.getText(),Double.parseDouble(esal2.getText())),
                new PieChart.Data(ename3.getText(),Double.parseDouble(esal3.getText())),
                new PieChart.Data(ename4.getText(),Double.parseDouble(esal4.getText())));

        datapie.forEach(datap->{
            String percentage = String.format("%.2f",(datap.getPieValue()/sum*100));
            datap.setName(datap.getName()+" "+ percentage +"%");
        });
        piechart.setData(datapie);

        
    }
    
    
    
}
