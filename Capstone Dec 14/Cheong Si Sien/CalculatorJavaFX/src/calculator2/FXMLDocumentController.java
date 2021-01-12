/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator2;

import static java.lang.Double.parseDouble;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 *
 * @author A
 */
public class FXMLDocumentController implements Initializable {
    
    static int indicator = 0;
    
    @FXML
    private Button b7;

    @FXML
    private Button b8;

    @FXML
    private Button b9;

    @FXML
    private Button b4;

    @FXML
    private Button b5;

    @FXML
    private Button b6;

    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Button b0;

    @FXML
    private Button bDecimal;

    @FXML
    private Button bEqual;

    @FXML
    private Button bPlus;

    @FXML
    private Button bMinus;

    @FXML
    private Button bTimes;

    @FXML
    private Button bDivide;

    @FXML
    private Button bClear;

    @FXML
    private TextField dispField;

        
    @FXML
    void handleButtonAction(ActionEvent event) throws ScriptException { 
    double results = 0;
   
    
    if (indicator == 1) {
      dispField.setText("");
              indicator = 0;}
    
    if (event.getSource() == b1)        {
       dispField.setText(dispField.getText() + "1");
       System.out.println("come here" + dispField.getText()); }
    if (event.getSource() == b2)        
       dispField.setText(dispField.getText() + "2");  
    if (event.getSource() == b3)        
       dispField.setText(dispField.getText() + "3");  
    if (event.getSource() == b4)        
       dispField.setText(dispField.getText() + "4");      
    if (event.getSource() == b5)        
       dispField.setText(dispField.getText() + "5");  
    if (event.getSource() == b6)        
       dispField.setText(dispField.getText() + "6");  
    if (event.getSource() == b7)        
       dispField.setText(dispField.getText() + "7");  
    if (event.getSource() == b8)        
       dispField.setText(dispField.getText() + "8");  
    if (event.getSource() == b9)        
       dispField.setText(dispField.getText() + "9");  
    if (event.getSource() == b0)        
       dispField.setText(dispField.getText() + "0");  
    if (event.getSource() == bDecimal)        
       dispField.setText(dispField.getText() + ".");  
    if (event.getSource() == bClear)        
       dispField.setText("");  
    if (event.getSource() == bPlus) 
        dispField.setText(dispField.getText() + "+");  
    if (event.getSource() == bMinus) 
        dispField.setText(dispField.getText() + "-");  
    if (event.getSource() == bTimes) 
        dispField.setText(dispField.getText() + "*");  
    if (event.getSource() == bDivide) 
        dispField.setText(dispField.getText() + "/");  
    
    if (event.getSource() == bEqual){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        dispField.setStyle("-fx-text-inner-color: blue");
     //   String truncated = String.valueOf((int) doubleValue);
    //    NumberFormat nf = NumberFormat.getNumberInstance();
     //   nf.setMaximumFractionDigits(0);
    //    String rounded = nf.format(doubleValue);
        DecimalFormat df = new DecimalFormat("#########.#########");
        //df.setRoundingMode(RoundingMode.);
        System.out.println("result is " + engine.eval(dispField.getText()));
        String rounded = df.format(engine.eval(dispField.getText()));
        indicator = 1;
        dispField.setText(rounded);
    }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
