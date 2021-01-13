/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author blueg
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button button1;
    @FXML
    private Label label1;
    @FXML
    private TextField textfield1;
    @FXML
    private Button button2;
    @FXML
    private TextField textfield2;
    @FXML
    private Label label2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void generateString(ActionEvent event) {
        String append = textfield1.getText().toUpperCase()+"\n";
        append = append +  " " + textfield1.getText().toLowerCase()+"\n";
        append = append + "The length of the string entered is: " +textfield1.getText().length()+"\n";
        label1.setText(append);
    }

    @FXML
    private void checkNumber(ActionEvent event) {
        int Number = Integer.parseInt(textfield2.getText());
        
        String primeNo;
        if(isPrime(Number)==true){
            primeNo = Number+ " is a prime number. \n";
        }else{
            primeNo = Number+ " is NOT a prime number. \n";
        }
        
        
        String oddNo;
        if(oddNumber(Number)==true){
            oddNo = Number+ " is an odd number. \n";
        }else{
            oddNo = Number+ " is NOT an odd number. \n";
        }
        

        label2.setText(primeNo + oddNo+ "The square of " +Number + " is: " +squaredNumber(Number)+", and its cube is: "+cubedNumber(Number));
        
    }
    
    private boolean oddNumber(int Number){
        if (Number%2==0){
            return false;
        }else{
            return true;
        }
    }
    
    private int squaredNumber(int Number){
        return Number*Number;
    }
    
    private int cubedNumber(int Number){
        return Number*Number*Number;
    }
    
    private boolean isPrime(int Number){
        if (Number <= 1) {
            return false;
        }

        // Check from 2 to n-1 
        for (int i = 2; i < Number; i++) {
            if (Number % i == 0) {
                return false;
            }
        }

        return true;
    }
    
}
