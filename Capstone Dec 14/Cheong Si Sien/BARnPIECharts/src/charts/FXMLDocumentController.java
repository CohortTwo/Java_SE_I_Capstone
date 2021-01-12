/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author A
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button BBar;
    @FXML
    private Button BPie;
 
    @FXML
    private TextField txtName1;
    @FXML
    private TextField txtSal1;
    @FXML
    private TextField txtName2;
    @FXML
    private TextField txtSal2;
    @FXML
    private TextField txtName3;
    @FXML
    private TextField txtSal3;
    @FXML
    private TextField txtSal4;
    @FXML
    private TextField txtName4;
    @FXML
    private TextField txtName5;
    @FXML
    private TextField txtSal5;
    @FXML
    private BarChart<?, ?> barchart;
    @FXML
    private PieChart piechart;
    @FXML
    private CheckBox boxcheck;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == BBar)
            displaybar();
        else if (event.getSource() == BPie)
            displaypie();
    }
    
    private void displaybar() {
        
        XYChart.Series set = new XYChart.Series<>();
        if (boxcheck.isSelected() == true)
        barchart.getData().clear();
        barchart.visibleProperty().set(true);
        piechart.visibleProperty().set(false);
        set.getData().add(new XYChart.Data(txtName1.getText(), Integer.parseInt(txtSal1.getText())));
        set.getData().add(new XYChart.Data(txtName2.getText(), Integer.parseInt(txtSal2.getText())));
        set.getData().add(new XYChart.Data(txtName3.getText(), Integer.parseInt(txtSal3.getText())));
        set.getData().add(new XYChart.Data(txtName4.getText(), Integer.parseInt(txtSal4.getText())));
        set.getData().add(new XYChart.Data(txtName5.getText(), Integer.parseInt(txtSal5.getText())));
       
        barchart.getData().addAll(set);
       
    }
    
        private void displaypie() {
        barchart.visibleProperty().set(false);
        piechart.visibleProperty().set(true);   
        ObservableList<PieChart.Data> piedata
                = FXCollections.observableArrayList(
                  new PieChart.Data(txtName1.getText(), Integer.parseInt(txtSal1.getText())),  
                  new PieChart.Data(txtName2.getText(), Integer.parseInt(txtSal2.getText())),
                  new PieChart.Data(txtName3.getText(), Integer.parseInt(txtSal3.getText())),
                  new PieChart.Data(txtName4.getText(), Integer.parseInt(txtSal4.getText())),
                  new PieChart.Data(txtName5.getText(), Integer.parseInt(txtSal5.getText())));
                  
        piechart.setData(piedata);
        
    }
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
