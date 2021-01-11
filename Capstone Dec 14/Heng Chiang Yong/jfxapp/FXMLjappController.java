/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfxapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author chiangyong
 */
public class FXMLjappController implements Initializable {

    @FXML
    private Button btnSubmit;
    @FXML
    private Label lbl1;
    @FXML
    private TextField txf1;
    @FXML
    private Label lbl2;

    @FXML
    private void handleButtonAction(ActionEvent event){
        String inputText = txf1.getText();
        NumOperator ops = new NumOperator();
        
       try
       {
        int number = Integer.parseInt(inputText);
        inputText = ops.primeNumber(number)+"\n"+
                ops.EvenOdd(number)
                +"\nThe cube of "+ number+ " is "+
                ops.CubeTheNumber(number)
                +"\nThe sqaure of "+ number+ " is "
                + ops.SquareTheNumber(number);
        
        lbl2.setText(inputText);
        
       }
       catch(Exception e)
       {
           System.err.println("Not an integer");
       }
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
