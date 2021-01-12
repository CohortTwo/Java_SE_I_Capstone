/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcalculatorapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author blueg
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button plus;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button minus;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button multiply;
    @FXML
    private Button zero;
    @FXML
    private Button equal;
    @FXML
    private Button divide;
    @FXML
    private TextField output;
    @FXML
    private Button clear;
    
    private Double memory;
    private int op;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()==one){
            output.setText(output.getText()+1);
        }else if(event.getSource()==two){
            output.setText(output.getText()+2);
        }else if(event.getSource()==three){
            output.setText(output.getText()+3);
        }else if(event.getSource()==four){
            output.setText(output.getText()+4);
        }else if(event.getSource()==five){
            output.setText(output.getText()+5);
        }else if(event.getSource()==six){
            output.setText(output.getText()+6);
        }else if(event.getSource()==seven){
            output.setText(output.getText()+7);
        }else if(event.getSource()==eight){
            output.setText(output.getText()+8);
        }else if(event.getSource()==nine){
            output.setText(output.getText()+9);
        }else if(event.getSource()==zero){
            output.setText(output.getText()+0);
        }else if(event.getSource()==clear){
            output.setText("");
        }else if(event.getSource()==plus){
            memory = Double.parseDouble(output.getText());
            op = 1;
            output.setText("");
        }else if(event.getSource()==minus){
            memory = Double.parseDouble(output.getText());
            op = 2;
            output.setText("");
        }else if(event.getSource()==multiply){
            memory = Double.parseDouble(output.getText());
            op = 3;
            output.setText("");
        }else if(event.getSource()==divide){
            memory = Double.parseDouble(output.getText());
            op = 4;
            output.setText("");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calculate(ActionEvent event) {
        if(op==1){
            output.setText(String.valueOf(memory+Double.parseDouble(output.getText())));
        }else if(op==2){
            output.setText(String.valueOf(memory-Double.parseDouble(output.getText())));
        }else if(op==3){
            output.setText(String.valueOf(memory*Double.parseDouble(output.getText())));
        }else if(op==4){
            output.setText(String.valueOf(memory/Double.parseDouble(output.getText())));
        }
    }
    
}
